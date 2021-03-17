package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;
import com.wei.utils.constant.AppConstant;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 全部诊断的adrg
 */
public class EventBusAllDiagnosisAdrg implements Observer {
    @Subscribe
    public void verify(EventArgs args) {
        //其他诊断编码,多个诊断用逗号分隔
        String[] diagCodes = args.getInParam().getNextDiagnosisCode().split(AppConstant.COMMA);

        List<String> allAdrgCode = new ArrayList<>();
        if (diagCodes != null) {
            for (String diagCode : diagCodes) {
                List<String> adrgCodeList = args.getMdcAdrgDiagList().stream()
                        .filter(m -> m.getAdrgCode().equals(diagCode) && m.getAdrgCode().length() == 3)
                        .map(m -> m.getAdrgCode()).distinct().collect(Collectors.toList());

                allAdrgCode.add(String.join(",", adrgCodeList));
            }
        }
        List<OutParam> outParams = args.getOutParams();
        if (outParams == null) {
            outParams = new LinkedList<>();
        }
        OutParam param = new OutParam();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        param.setRemark("全部诊断的ADRG是--");
        param.setResult(String.join(",", allAdrgCode));
        outParams.add(param);
    }

    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
}
