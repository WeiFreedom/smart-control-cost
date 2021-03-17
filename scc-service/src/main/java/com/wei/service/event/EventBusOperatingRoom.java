package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;
import com.wei.utils.constant.AppConstant;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 是否有手术室手术
 */
public class EventBusOperatingRoom implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
    //@Subscribe
    public void verify(EventArgs args){
        boolean isValid = args.getDiseases()
                .stream()
                .filter(m->m.getDiagType()=="03" && m.getOperFlag().equals(AppConstant.Y))
                .anyMatch(n->n.getDiagCode().equals(args.getInParam().getOperationCode()));

        List<OutParam> outParams = args.getOutParams();
        if(outParams==null){
            outParams = new LinkedList<>();
        }
        OutParam param = new OutParam();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex()+1);
        param.setRemark("是否有手术室手术--");
        param.setResult(isValid);
        outParams.add(param);
    }
}
