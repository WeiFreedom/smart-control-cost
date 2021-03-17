package com.wei.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.eventbus.EventBus;
import com.wei.dao.DiseaseMapper;
import com.wei.dto.VerifyPageMedicalRecordDto;
import com.wei.entity.*;
import com.wei.dao.PageMedicalRecordMapper;
import com.wei.service.IPageMedicalRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.service.event.DrgsEventBus;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.InParam;
import com.wei.service.event.entity.OutParam;
import com.wei.utils.AssertUtils;
import com.wei.utils.StringUtils;
import com.wei.utils.cache.RedisUtils;
import com.wei.utils.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
* <p>
    * 病案首页的表 服务实现类
    * </p>
*
* @author wei
* @since 2021-03-04
*/
@Service
@Transactional
public class PageMedicalRecordServiceImpl extends ServiceImpl<PageMedicalRecordMapper, PageMedicalRecord> implements IPageMedicalRecordService {
    @Autowired
    private PageMedicalRecordMapper pageMedicalRecordMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private DiseaseMapper diseaseMapper;
//    @Autowired
//    private EventBus eventBus;

    @Autowired
    private DrgsEventBus eventBus;

    private static final String MDCADRGLIST_CACHEKEY = MdcAdrg.class.getName() + "#getMdcAdrgList";
    private static final String MDCADRGDIAGLIST_CACHEKEY = MdcAdrgDiag.class.getName() + "#getMdcAdrgDiagList";
    private static final String DISEASELIST_CACHEKEY = Disease.class.getName() + "#getDiseaseList";
    private static final String DRGMCCLIST_CACHEKEY = DrgMcc.class.getName() + "#getDrgMccList";
    private static final String DRGCCLIST_CACHEKEY = DrgCc.class.getName() + "#getDrgCcList";
    private static final String MCEXC_CACHEKEY = McExc.class.getName() + "#getMcExcList";

    public List<VerifyPageMedicalRecordDto> verifyPageMedicalRecordList(Map<String, String> map){

        String startDt = map.get("startDt");
        String endDt = map.get("endDt");
        AssertUtils.notNull(startDt,"开始时间不能为空");
        AssertUtils.notNull(endDt,"结束时间不能为空");
        List<VerifyPageMedicalRecordDto> dots = pageMedicalRecordMapper.verifyPageMedicalRecordList(startDt,endDt);

        if(dots!=null && dots.size()>0) {

            List<MdcAdrgDiag> mdcAdrgDiags = getMdcAdrgDiagList();

            for (VerifyPageMedicalRecordDto dto : dots) {
                //拿到满足手术和主要诊断的所有的Adrg诊断手术操作列表
                List<MdcAdrgDiag> filters = mdcAdrgDiags.stream().filter(m->
                     dto.getDiagCode().equals(m.getDiagCode()) || dto.getOperCode().equals(m.getDiagCode())).collect(Collectors.toList());
                if(verifyRationality(filters)){//验证成功
                    dto.setVerifyRationality(AppConstant.Y);
                }else{
                    dto.setVerifyRationality(AppConstant.N);
                }
            }
        }

        return dots;
    }


    public List<OutParam> drgs(Map<String, Object> map){
        String mainDiagnosisCode = map.get("mainDiagnosisCode").toString();//诊断编码
        String nextDiagnosisCode = map.get("nextDiagnosisCode").toString();//其他诊断
        String operationCode = map.get("operationCode").toString();//手术编码
        String sex = map.get("sex").toString();//性别
        int age = 0;//年龄
        if(!StringUtils.isEmpty(map.get("age").toString())){
            age = Integer.parseInt(map.get("age").toString());
        }
        int newbornAge  = 0;//新生儿
        if(!StringUtils.isEmpty(map.get("newbornAge").toString())){
            newbornAge = Integer.parseInt(map.get("newbornAge").toString());
        }
        float newbornWeight = 0f;
        if(!StringUtils.isEmpty(map.get("newbornWeight").toString())){
            newbornWeight = Float.parseFloat(map.get("newbornWeight").toString());
        }
        int daysStay= 0;//住院天数不能大于60天
        if(!StringUtils.isEmpty(map.get("daysStay").toString())){
            daysStay = Integer.parseInt(map.get("daysStay").toString());
        }
        BigDecimal chargeStay = new BigDecimal(0);//花费
        if(!StringUtils.isEmpty(map.get("chargeStay").toString())){
            chargeStay = new BigDecimal(map.get("chargeStay").toString());
        }
        String leavingWay = map.get("leavingWay").toString();//离院方式

        AssertUtils.notEmpty(mainDiagnosisCode, "主诊断编码不能为空");
        AssertUtils.notNull(age, "年龄不能为空");



        InParam inParam = new InParam();
        inParam.setMainDiagnosisCode(mainDiagnosisCode);
        inParam.setNextDiagnosisCode(nextDiagnosisCode);
        inParam.setOperationCode(operationCode);
        inParam.setSex(sex);
        inParam.setAge((age));
        inParam.setNewbornAge(newbornAge);
        inParam.setNewbornWeight(newbornWeight);
        inParam.setDaysStay(daysStay);
        inParam.setChargeStay(chargeStay);
        inParam.setLeavingWay(leavingWay);


        List<OutParam> list = new ArrayList<>();

        EventArgs args = new EventArgs();
        args.setIndex(1);
        args.setDiseases(getDiseaseList());
        args.setDrgCcs(getDrgCcList());
        args.setDrgMccs(getDrgMccList());
        args.setMcExcs(getMcExcList());
        args.setMdcAdrgDiagList(getMdcAdrgDiagList());
        args.setMdcAdrgList(getMdcAdrgList());
        args.setInParam(inParam);
        args.setOutParams(list);

        //eventBus.post(args);
        eventBus.invoke(args);
        return args.getOutParams();
    }
    /**
     * 验证主要诊断与主要手术匹配合理性
     * @param source
     * @return
     */
    private boolean verifyRationality(List<MdcAdrgDiag> source){
        List<MdcAdrg> mdcAdrgs = getMdcAdrgList();
        for(MdcAdrgDiag filter : source){
            if(mdcAdrgs.stream().anyMatch(m->m.getAdrgCode().equals(filter.getAdrgCode()))
            && "03".equals(filter.getDiagType())){ //如果adrg编码匹配 例如 BL1 并且是手术/操作的话 那么才验证后面
                MdcAdrg mdcAdrg = mdcAdrgs.stream().filter(m->m.getMdcCode().equals(filter.getAdrgCode())).findFirst().get();
                if(!StringUtils.isEmpty(mdcAdrg.getAdrgCondition())){ //如果AdrgCondition不为空 那么意味着会同时存在
                    String[] strs = mdcAdrg.getAdrgCondition().split(AppConstant.HORIZONTALLINE);
                    boolean result = true;
                    for (String str : strs){
                        if(StringUtils.isEmpty(str)){
                            continue;
                        }
                        Optional<MdcAdrgDiag> first = source.stream().filter(m -> str.equals(m.getAdrgCondition())).findFirst();
                        if(!first.isPresent()){//查询对象是否存在
                            result = false;
                        }
                    }
                    if(result && verifyMainDiagnosis(mdcAdrgs,source,filter)){
                        return true;
                    }
                }
                else{//如果不同时存在的话 也就是说存在一个就行
                    if(verifyMainDiagnosis(mdcAdrgs,source,filter)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断主诊断是否存在
     * @param mdcAdrgs
     * @param source
     * @param current
     * @return
     */
    private boolean verifyMainDiagnosis(List<MdcAdrg> mdcAdrgs,List<MdcAdrgDiag> source,MdcAdrgDiag current){
        Optional<MdcAdrg> first = mdcAdrgs.stream().filter(m -> m.getAdrgCode().equals(current.getAdrgCode())).findFirst();
        if(!first.isPresent()){
            return true;
        }
        MdcAdrg mdcAdrg = first.get();

        Optional<MdcAdrgDiag> main = source.stream().filter(m -> m.getAdrgCode().equals(mdcAdrg.getMdcCode())).findFirst();
        if(main.isPresent()){
            return true;
        }
        return false;
    }

    /**
     * 获取所有的MdcAdrg列表 因为数据基本不变 所以可以走缓存
     * @return
     */
    private List<MdcAdrg> getMdcAdrgList(){
        List<MdcAdrg> result = (List<MdcAdrg>)redisUtils.get(MDCADRGLIST_CACHEKEY);
        if(result==null){
            result = pageMedicalRecordMapper.getMdcAdrgList();
            redisUtils.set(MDCADRGLIST_CACHEKEY, result);
        }
        return result;
    }

    /**
     * 获取所有的MdcAdrgDiag列表
     * @return
     */
    private List<MdcAdrgDiag> getMdcAdrgDiagList(){
        List<MdcAdrgDiag> result = (List<MdcAdrgDiag>)redisUtils.get(MDCADRGDIAGLIST_CACHEKEY);
        if(result==null){
            result = pageMedicalRecordMapper.getMdcAdrgDiagList();
            redisUtils.set(MDCADRGDIAGLIST_CACHEKEY, result);
        }
        return result;
    }

    /**
     * 获取医保局诊断字典
     * @return
     */
    private List<Disease> getDiseaseList(){
      List<Disease> diseases =(List<Disease>)  redisUtils.get(DISEASELIST_CACHEKEY);
        if(diseases==null) {
            QueryWrapper<Disease> wrapper = Wrappers.query();
            wrapper.in("tc_diag_Type", Arrays.asList("01", "03"));
            diseases = diseaseMapper.selectList(wrapper);
            redisUtils.set(DISEASELIST_CACHEKEY,diseases);
        }
        return diseases;
    }

    private List<DrgMcc> getDrgMccList(){
        List<DrgMcc> drgMccs = (List<DrgMcc>)  redisUtils.get(DRGMCCLIST_CACHEKEY);
        if(drgMccs==null){
            drgMccs = pageMedicalRecordMapper.getDrgMccList();
            redisUtils.set(DRGMCCLIST_CACHEKEY,drgMccs);
        }
        return drgMccs;
    }

    private List<DrgCc> getDrgCcList(){
        List<DrgCc> drgCcs = (List<DrgCc>)  redisUtils.get(DRGCCLIST_CACHEKEY);
        if(drgCcs==null){
            drgCcs = pageMedicalRecordMapper.getDrgCcList();
            redisUtils.set(DRGCCLIST_CACHEKEY,drgCcs);
        }
        return drgCcs;
    }

    private List<McExc> getMcExcList(){
        List<McExc> mcExcs = (List<McExc>)  redisUtils.get(MCEXC_CACHEKEY);
        if(mcExcs==null){
            mcExcs = pageMedicalRecordMapper.getMcExcList();
            redisUtils.set(MCEXC_CACHEKEY,mcExcs);
        }
        return mcExcs;
    }


}
