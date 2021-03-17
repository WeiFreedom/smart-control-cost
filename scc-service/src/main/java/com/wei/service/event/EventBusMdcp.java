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
 * 是否MDCP
 */
public class EventBusMdcp implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
    //@Subscribe
    public void verify(EventArgs args) {
////获取所有的MDCP列表
//        List<MdcAdrg> mdcAdrgs = args.getMdcAdrgList().stream()
//                .filter(m -> "MDCP".equals(m.getAdrgCode()))
//                .collect(Collectors.toList());
//        //以P开始的所有的ADRG列表
//        List<MdcAdrgDiag> mdcAdrgDiags = args.getMdcAdrgDiagList().stream()
//                .filter(m -> m.getAdrgCode().startsWith("P"))
//                .collect(Collectors.toList());
//
//        //获取第二布 全部手术/操作的ADRG
//        OutParam param = args.getOutParams().get(1);
//        String adrgs = (String) param.getResult();
//
//        String operationCodes = args.getInParam().getOperationCode();
//
//
//        boolean isValid = false;
//        //先判断一个是否存在MDCP的主诊断
//        OutParam mainParam = args.getOutParams().get(0);
//        String mainResult = (String) mainParam.getResult();
//        OutParam allParam = args.getOutParams().get(3);
//        String allResult = (String) allParam.getResult();
//
//        if (Arrays.asList(mainResult.split(AppConstant.COMMA)).stream().anyMatch(m -> m.startsWith("P"))
//        || Arrays.asList(allResult.split(AppConstant.COMMA)).stream().anyMatch(m -> m.startsWith("P"))
//        || Arrays.asList(operationCodes.split(AppConstant.COMMA)).stream().anyMatch(m -> m.startsWith("P"))) {
//
//            List<MdcAdrg> filters = mdcAdrgs.stream().filter(m -> adrgs.contains(m.getAdrgCode()))
//                    .collect(Collectors.toList());
//            if (filters != null && filters.size() > 0) {
//                for (MdcAdrg mdcAdrg : filters) {
//                    if (!StringUtils.isEmpty(mdcAdrg.getAdrgCondition())) {
//                        String[] splits = mdcAdrg.getAdrgCondition().split(AppConstant.HORIZONTALLINE);
//                        //再过滤一层
//                        List<String> temps = mdcAdrgDiags.stream().filter(v ->
//                                v.getAdrgCode().equals(mdcAdrg.getAdrgCode()) &&
//                                        v.getDiagType().equals("03") &&
//                                        operationCodes.contains(v.getDiagCode()) &&
//                                        Arrays.asList(splits).contains(v.getAdrgCondition()))
//                                .map(n -> n.getAdrgCondition() + "").distinct().collect(Collectors.toList());
//                        if (splits.length == temps.size()) {
//                            isValid = true;
//                            break;
//                        }
//                    } else {
//                        isValid = true;
//                        break;
//                    }
//                }
//            }
//        }
//
//        List<OutParam> outParams = args.getOutParams();
//        if (outParams == null) {
//            outParams = new LinkedList<>();
//        }
//        OutParam outParam = new OutParam();
//        outParam.setCurrentIndex(args.getIndex());
//        args.setIndex(args.getIndex() + 1);
//        outParam.setRemark("是否MDCP--");
//        outParam.setResult(isValid);
//        outParams.add(outParam);
        List<OutParam> outParams = args.getOutParams();
        if (outParams == null) {
            outParams = new LinkedList<>();
        }
        OutParam outParam = new OutParam();
        outParam.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        outParam.setRemark("是否MDCP--");
        outParam.setResult(false);
        outParams.add(outParam);
    }
}
