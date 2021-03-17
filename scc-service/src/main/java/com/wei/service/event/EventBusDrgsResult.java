package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EventBusDrgsResult implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
   // @Subscribe
    public void verify(EventArgs args){
        OutParam param11 = args.getOutParams().get(11);//ADRG
        OutParam param4 = args.getOutParams().get(4);//MCC
        OutParam param5 = args.getOutParams().get(5);//CC
String result = param11.getResult().toString();
        if((boolean)param4.getResult()){
            result = result + "1";
        } else if((boolean)param5.getResult()){
            result = result + "3";
        }else if(args.getInParam().getLeavingWay().equals("7")){
            result = result + "7";
        }else if(args.getInParam().getLeavingWay().equals("9")){
            result = result + "9";
        }else{
            result = result + "5";
        }
        OutParam param = new OutParam();
        List<OutParam> outParams = args.getOutParams();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        param.setRemark("DRGs是--");
        param.setResult(result);
        outParams.add(param);
    }
}
