package com.wei.service.event;

import com.google.common.eventbus.Subscribe;
import com.wei.service.event.entity.EventArgs;
import com.wei.service.event.entity.OutParam;
import com.wei.utils.constant.AppConstant;

import java.util.*;

public class EventBusAdrgResult implements Observer {
    //因为使用eventbus的方式没有顺序 所以不能使用
    //@Subscribe
    public void verify(EventArgs args) {

        String result = "";
        OutParam param = new OutParam();

        OutParam param6 = args.getOutParams().get(6);//MDCA
        OutParam param0 = args.getOutParams().get(0);
        OutParam param1 = args.getOutParams().get(1);
        OutParam param3 = args.getOutParams().get(3);
        OutParam param7 = args.getOutParams().get(7);//MDCP
        OutParam param8 = args.getOutParams().get(8);//MDCY
        OutParam param10 = args.getOutParams().get(9);//MDCZ

        String all = param0.getResult() + "," +  param1.getResult() + "," + param3.getResult();
        if ((boolean) param6.getResult()) {
            Optional<String> a = Arrays.asList((all).split(AppConstant.COMMA))
                    .stream().filter(m -> m.startsWith("A")).findFirst();
            if(a.isPresent()){
                result = a.get();
            }
        } else if ((boolean) param7.getResult()) {
            Optional<String> a = Arrays.asList((all).split(AppConstant.COMMA))
                    .stream().filter(m -> m.startsWith("P")).findFirst();
            if(a.isPresent()){
                result = a.get();
            }
        } else if ((boolean) param8.getResult()) {
            Optional<String> a = Arrays.asList((all).split(AppConstant.COMMA))
                    .stream().filter(m -> m.startsWith("Y")).findFirst();
            if(a.isPresent()){
                result = a.get();
            }
        } else if ((boolean) param10.getResult()) {
            Optional<String> a = Arrays.asList((all).split(AppConstant.COMMA))
                    .stream().filter(m -> m.startsWith("Z")).findFirst();
            if(a.isPresent()){
                result = a.get();
            }
        } else {
            List<String> list1 = Arrays.asList(((String)param0.getResult()).split(AppConstant.COMMA));
            List<String> list2 = Arrays.asList(((String)param1.getResult()).split(AppConstant.COMMA));
            List<String> list3 = Arrays.asList(((String)param3.getResult()).split(AppConstant.COMMA));

            list1.retainAll(list2);
            list1.retainAll(list3);
            if(list1.size()>0){
                result = list1.get(0);
            } else{
                result = Arrays.asList(((String)param0.getResult()).split(AppConstant.COMMA))
                        .get(0);
            }
        }

        List<OutParam> outParams = args.getOutParams();
        param.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        param.setRemark("最终的ADRG是--");
        param.setResult(result);
        outParams.add(param);
    }

    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
}
