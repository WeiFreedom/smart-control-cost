package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EventBusMdczPart implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
    //@Subscribe
    public void verify(EventArgs args){
        List<OutParam> outParams = args.getOutParams();
        if(outParams==null){
            outParams = new LinkedList<>();
        }
        OutParam param = new OutParam();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex()+1);
        param.setRemark("MDCZ部位--");
        param.setResult(false);
        outParams.add(param);
    }
}
