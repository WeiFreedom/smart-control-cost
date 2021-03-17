package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.entity.DrgCc;
import com.wei.entity.DrgMcc;
import com.wei.entity.McExc;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;
import com.wei.utils.constant.AppConstant;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class EventBusCc implements Observer {
   // @Subscribe
    public void verify(EventArgs args){
//其他诊断编码,多个诊断用逗号分隔
        String[] diagCodes = args.getInParam().getNextDiagnosisCode().split(AppConstant.COMMA);

        List<DrgCc> drgCcs = args.getDrgCcs();
        List<McExc> mcExcs = args.getMcExcs();

        boolean isValid = false;
        if(diagCodes!=null){
            for(String diagCode : diagCodes){
                List<DrgCc> collect = drgCcs.stream().filter(m -> m.getDiagCode().equals(diagCode))
                        .collect(Collectors.toList());
                boolean isBreak = false;
                for(DrgCc drgCc: collect){
                    if(mcExcs.stream().noneMatch(n->n.getMcExcCode().equals(drgCc.getMcExcCode()))){
                        isValid = true;
                        isBreak = true;
                        break;
                    }
                }
                if(isBreak){
                    break;
                }
            }
        }

        List<OutParam> outParams = args.getOutParams();
        if (outParams == null) {
            outParams = new LinkedList<>();
        }
        OutParam param = new OutParam();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        param.setRemark("是否CC--");
        param.setResult(isValid);
        outParams.add(param);
    }

    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
}
