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
 * 是否Mdcz
 */
public class EventBusMdcz implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        verify((EventArgs)arg);
    }
    //@Subscribe
    public void verify(EventArgs args){
        List<OutParam> outParams = args.getOutParams();
        if (outParams == null) {
            outParams = new LinkedList<>();
        }
        OutParam outParam = new OutParam();
        outParam.setCurrentIndex(args.getIndex());
        args.setIndex(args.getIndex() + 1);
        outParam.setRemark("是否MDCZ--");
        outParam.setResult(false);
        outParams.add(outParam);
    }
}
