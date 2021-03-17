package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EventBusResult implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
    //@Subscribe
    public void verify(EventArgs args){
        OutParam param12 = args.getOutParams().get(12);

        OutParam param = new OutParam();
        List<OutParam> outParams = args.getOutParams();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        param.setRemark("最终的DRGs是--");
        param.setResult(param12.getResult().toString());
        outParams.add(param);
    }
}
