package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.entity.MdcAdrg;
import com.wei.entity.MdcAdrgDiag;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;
import com.wei.utils.StringUtils;
import com.wei.utils.constant.AppConstant;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 是否MDCA
 */
public class EventBusMdca implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
    //@Subscribe
    public void verify(EventArgs args){
        //获取所有的MDCA列表
        List<MdcAdrg> mdcAdrgs = args.getMdcAdrgList().stream()
                .filter(m->"MDCA".equals(m.getAdrgCode()))
                .collect(Collectors.toList());
        //以A开始的所有的ADRG列表
        List<MdcAdrgDiag> mdcAdrgDiags = args.getMdcAdrgDiagList().stream()
                .filter(m->m.getAdrgCode().startsWith("A"))
                .collect(Collectors.toList());

        //获取第二布 全部手术/操作的ADRG
        OutParam param = args.getOutParams().get(1);
        String adrgs = (String)param.getResult();

        String operationCodes = args.getInParam().getOperationCode();

        boolean isValid = false;
        List<MdcAdrg> filters = mdcAdrgs.stream().filter(m->adrgs.contains(m.getAdrgCode()))
                .collect(Collectors.toList());
        if(filters!=null && filters.size()>0){
            for(MdcAdrg mdcAdrg : filters){
                if(!StringUtils.isEmpty(mdcAdrg.getAdrgCondition())){
                    String[] splits = mdcAdrg.getAdrgCondition().split(AppConstant.HORIZONTALLINE);
                    //再过滤一层
                    List<String> temps = mdcAdrgDiags.stream().filter(v->
                            v.getAdrgCode().equals(mdcAdrg.getAdrgCode()) &&
                                    operationCodes.contains(v.getDiagCode()) &&
                            Arrays.asList(splits).contains(v.getAdrgCondition()))
                            .map(n->n.getAdrgCondition()+"").distinct().collect(Collectors.toList());
                    if(splits.length ==temps.size()){
                        isValid = true;
                        break;
                    }
                }else{
                    isValid = true;
                    break;
                }
            }
        }

        List<OutParam> outParams = args.getOutParams();
        if (outParams == null) {
            outParams = new LinkedList<>();
        }
        OutParam outParam = new OutParam();
        outParam.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        outParam.setRemark("是否MDCA--");
        outParam.setResult(isValid);
        outParams.add(outParam);
    }
}
