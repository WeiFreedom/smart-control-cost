package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.entity.MdcAdrgDiag;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 主要诊断编码的ADRG
 */
public class EventBusMainDiagnosisAdrg implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
   // @Subscribe
    public void verify(EventArgs args){
        //主要诊断编码
        String diagCode = args.getInParam().getMainDiagnosisCode();

        List<String> adrgCodeList = args.getMdcAdrgDiagList().stream()
                .filter(m->m.getAdrgCode().equals(diagCode) && m.getAdrgCode().length() == 3)
                .map(m->m.getAdrgCode()).distinct().collect(Collectors.toList());

        List<OutParam> outParams = args.getOutParams();
        if(outParams==null){
            outParams = new LinkedList<>();
        }
        OutParam param = new OutParam();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex()+1);
        param.setRemark("主要诊断的ADRG是--");
        param.setResult(String.join(",",adrgCodeList));
        outParams.add(param);
    }
}
