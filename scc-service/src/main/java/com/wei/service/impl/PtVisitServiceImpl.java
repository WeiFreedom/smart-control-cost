package com.wei.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wei.dto.DictionaryDto;
import com.wei.dto.PtVisitMiStatisticsDto;
import com.wei.entity.PtVisit;
import com.wei.dao.PtVisitMapper;
import com.wei.service.IPtVisitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.utils.BeanUtils;
import com.wei.utils.CollectionUtils;
import com.wei.utils.DateTimeUtils;
import com.wei.utils.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wei
 * @since 2021-02-18
 */
@Service
@Transactional
public class PtVisitServiceImpl extends ServiceImpl<PtVisitMapper, PtVisit> implements IPtVisitService {
    @Autowired
    private PtVisitMapper ptVisitMapper;

    public Map<String, Object> medicarePatientsNumber(int month) {
        List<PtVisitMiStatisticsDto> dtos = ptVisitMapper.medicarePatientsNumber(month);
        if (CollectionUtils.isEmpty(dtos)) {
            return null;
        }
        Date now = DateTimeUtils.now();
        for (int index = month; index >= 0; index--) {
            String calc = DateTimeUtils.format(DateTimeUtils.addMonths(now, -index), DateTimeUtils.MONTH_FORMAT);
            if (dtos.stream().noneMatch(m -> m.getMonth().equals(calc)) ||
                    (dtos.stream().anyMatch(m -> m.getMonth().equals(calc)
                    && (!"0".equals(m.getType()) || !"1".equals(m.getType()) || !"2".equals(m.getType()) || !"3".equals(m.getType()))) )) {
                List<PtVisitMiStatisticsDto> filter = dtos.stream().filter(n -> calc.equals(n.getMonth())).collect(Collectors.toList());
                PtVisitMiStatisticsDto dto = new PtVisitMiStatisticsDto();
                dto.setMonth(calc);
                dto.setMiNumber(0);
                dto.setTotal(0);
                if (filter.stream().noneMatch(m -> "0".equals(m.getType()))) {
                    dto.setType("0");
                    dtos.add(dto);
                }
                if (filter.stream().noneMatch(m -> "1".equals(m.getType()))) {
                    dto = BeanUtils.clone(dto);
                    dto.setType("1");
                    dtos.add(dto);
                }
                if (filter.stream().noneMatch(m -> "2".equals(m.getType()))) {
                    dto = BeanUtils.clone(dto);
                    dto.setType("2");
                    dtos.add(dto);
                }
                if (filter.stream().noneMatch(m -> "3".equals(m.getType()))) {
                    dto = BeanUtils.clone(dto);
                    dto.setType("3");
                    dtos.add(dto);
                }
            }
        }
        // Collections.sort(dtos, (PtVisitMiStatisticsDto c1,PtVisitMiStatisticsDto c2) -> c1.getMonth().compareTo(c2.getMonth()));
        Map<String, Object> map = new HashMap<>();

        //获取第一个仪表板内容
        List<PtVisitMiStatisticsDto> filter = dtos.stream().filter(m -> m.getMonth().equals(DateTimeUtils.format(DateTimeUtils.addMonths(now, -1), DateTimeUtils.MONTH_FORMAT))).collect(Collectors.toList());
        Map<String, Integer> dashboard1 = new HashMap<>();
        filter.forEach(m -> {
            if (!"3".equals(m.getType())) {//不是体检
                dashboard1.put(m.getType(), m.getMiNumber());
            }
        });
        map.put("dashboard1", dashboard1);
        //获取第二个仪表盘内容
        Map<String, Object> dashboard2 = new HashMap<>();
        //1)单个字段 单个汇总
        //dtos.stream().collect(Collectors.groupingBy(PtVisitMiStatisticsDto :: getMonth, Collectors.summarizingLong(PtVisitMiStatisticsDto:: getTotal)));
        //2)多个字段 单个汇总
        //dtos.stream().collect(Collectors.groupingBy(PtVisitMiStatisticsDto :: getMonth,Collectors.groupingBy(PtVisitMiStatisticsDto :: getType, Collectors.summarizingLong(PtVisitMiStatisticsDto:: getTotal))));
        //3)单个字段 多个汇总
        Map<String, PtVisitMiStatisticsDto> collect = dtos.stream()
                .collect(Collectors.groupingBy(PtVisitMiStatisticsDto::getMonth, Collectors.collectingAndThen(Collectors.toList(), m -> {
            final int total = m.stream().mapToInt(PtVisitMiStatisticsDto::getTotal).sum();
            final int mi = m.stream().mapToInt(PtVisitMiStatisticsDto::getMiNumber).sum();
            final PtVisitMiStatisticsDto statistics = new PtVisitMiStatisticsDto();
            statistics.setTotal(total);
            statistics.setMiNumber(mi);
            return statistics;
        })));
        List<Object> list1 = new ArrayList<>();
        List<BigDecimal> list2 = new ArrayList<>();
        // TODO 后期需要优化一下子
        //排序
        List<Map.Entry<String, PtVisitMiStatisticsDto>> sort = new ArrayList<Map.Entry<String, PtVisitMiStatisticsDto>>(collect.entrySet());
        Collections.sort(sort, new Comparator<Map.Entry<String, PtVisitMiStatisticsDto>>() {
            @Override
            public int compare(Map.Entry<String, PtVisitMiStatisticsDto> o1, Map.Entry<String, PtVisitMiStatisticsDto> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        collect = new LinkedHashMap<>();
        for(Map.Entry<String, PtVisitMiStatisticsDto> entry : sort){
            collect.put(entry.getKey(), entry.getValue());
        }

        collect.forEach((k, v) -> {
            list1.add(k.substring(k.indexOf(AppConstant.HORIZONTALLINE)+1) + AppConstant.CHAR_MONTH);
            if(0==v.getTotal()){
                list2.add(new BigDecimal(0));
            } else{
                BigDecimal miNumber = new BigDecimal(v.getMiNumber());
                BigDecimal total = new BigDecimal(v.getTotal());
                list2.add(miNumber.divide(total).setScale(4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            }
        });
        dashboard2.put("xAxis", list1);
        dashboard2.put("data", list2);
        map.put("dashboard2", dashboard2);

        //获取第三个仪表盘内容
        List<DictionaryDto> dashboard3 = new ArrayList<>();
        collect.forEach((k, v) -> {
            List<Map<String, Object>> ls = new ArrayList<>();
            DictionaryDto dictionaryDto = new DictionaryDto();
            String kk = k.substring(k.indexOf(AppConstant.HORIZONTALLINE)+1) + AppConstant.CHAR_MONTH;
            dictionaryDto.setName(kk);
            if(0==v.getTotal()){
                dictionaryDto.setValue(new BigDecimal(0));
            } else{
                BigDecimal miNumber = new BigDecimal(v.getMiNumber());
                BigDecimal total = new BigDecimal(v.getTotal());
                dictionaryDto.setValue(miNumber.divide(total).setScale(4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(10000)));
            }

            dashboard3.add(dictionaryDto);
        });
        map.put("dashboard3", dashboard3);

        //获取第四个仪表盘内容
        Map<String, Object> dashboard4 = new HashMap<>();
        //4)多个字段 多个汇总
        Map<String, Map<String, PtVisitMiStatisticsDto>> group = dtos.stream().collect(Collectors.groupingBy(PtVisitMiStatisticsDto::getMonth, Collectors.groupingBy(PtVisitMiStatisticsDto::getType, Collectors.collectingAndThen(Collectors.toList(), m -> {
            final int total = m.stream().mapToInt(PtVisitMiStatisticsDto::getTotal).sum();
            final int mi = m.stream().mapToInt(PtVisitMiStatisticsDto::getMiNumber).sum();
            final PtVisitMiStatisticsDto statistics = new PtVisitMiStatisticsDto();
            statistics.setTotal(total);
            statistics.setMiNumber(mi);
            return statistics;
        }))));
        //排序
        List<Map.Entry<String, Map<String, PtVisitMiStatisticsDto>>> s = new ArrayList<Map.Entry<String, Map<String, PtVisitMiStatisticsDto>>>(group.entrySet());
        Collections.sort(s, new Comparator<Map.Entry<String, Map<String, PtVisitMiStatisticsDto>>>() {
            @Override
            public int compare(Map.Entry<String, Map<String, PtVisitMiStatisticsDto>> o1, Map.Entry<String, Map<String, PtVisitMiStatisticsDto>> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        group = new LinkedHashMap<>();
        for(Map.Entry<String, Map<String, PtVisitMiStatisticsDto>> entry : s){
            group.put(entry.getKey(), entry.getValue());
        }
        List<String> category = new ArrayList<>();
        Map<String, List<Integer>> datas = new HashMap<>();
        List<Integer> data1 = new ArrayList<>();
        List<Integer> data2 = new ArrayList<>();
        List<Integer> data3 = new ArrayList<>();
        group.forEach((k,items) ->{
            String kk = k.substring(k.indexOf(AppConstant.HORIZONTALLINE)+1) + AppConstant.CHAR_MONTH;
            category.add(kk);
            items.forEach((key, item)->{
               if("0".equals(key)){
                   data1.add(item.getMiNumber());
               } else if("1".equals(key)){
                   data2.add(item.getMiNumber());
               }else if("2".equals(key)){
                   data3.add(item.getMiNumber());
               }
            });
        });
        datas.put("0",data1);
        datas.put("1",data2);
        datas.put("2",data3);
        dashboard4.put("category", category);
        dashboard4.put("data", datas);
        map.put("dashboard4",dashboard4);

        return map;
    }
}
