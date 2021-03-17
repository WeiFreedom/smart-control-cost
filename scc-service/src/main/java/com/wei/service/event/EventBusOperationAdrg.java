package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;
import com.wei.utils.constant.AppConstant;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 手术操作的Adrg
 */
public class EventBusOperationAdrg implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
    //@Subscribe
    public void verify(EventArgs args) {
        //主要手术编码 多个手术编码使用逗号分隔
        String[] operationCodes = args.getInParam().getOperationCode().split(AppConstant.COMMA);
        List<String> all = new ArrayList<>();
        if (operationCodes != null) {
            for (String operationCode : operationCodes) {
                List<String> adrgCodeList = args.getMdcAdrgDiagList().stream()
                        .filter(m -> m.getAdrgCode().equals(operationCode) && m.getAdrgCode().length() == 3)
                        .map(m -> m.getAdrgCode()).distinct().collect(Collectors.toList());
                all.addAll(adrgCodeList);
            }
        }
        List<OutParam> outParams = args.getOutParams();
        if (outParams == null) {
            outParams = new LinkedList<>();
        }
        OutParam param = new OutParam();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        param.setRemark("手术/操作的ADRG是--");
        param.setResult(String.join(",", all));
        outParams.add(param);

    }
}
