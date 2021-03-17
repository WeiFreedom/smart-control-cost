package com.wei.service.event;

import com.wei.service.event.entity.EventArgs;

import java.util.Observable;

public class DrgsEventBus extends Observable {
    public void  invoke(EventArgs args){
        setChanged();
        notifyObservers(args);
    }
}
