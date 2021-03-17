package com.wei.web.config;

import com.google.common.eventbus.EventBus;
import com.wei.service.event.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBusConfig {

    @Bean
    public DrgsEventBus drgsEventBus(){
        DrgsEventBus drgsEventBus = new DrgsEventBus();

        drgsEventBus.addObserver(new EventBusResult());
        drgsEventBus.addObserver(new EventBusDrgsResult());
        drgsEventBus.addObserver(new EventBusAdrgResult());
        drgsEventBus.addObserver(new EventBusMdcz());
        drgsEventBus.addObserver(new EventBusMdczPart());
        drgsEventBus.addObserver(new EventBusMdcy());
        drgsEventBus.addObserver(new EventBusMdcp());
        drgsEventBus.addObserver(new EventBusMdca());
        drgsEventBus.addObserver(new EventBusCc());
        drgsEventBus.addObserver(new EventBusMcc());
        drgsEventBus.addObserver(new EventBusAllDiagnosisAdrg());
        drgsEventBus.addObserver(new EventBusOperatingRoom());
        drgsEventBus.addObserver(new EventBusOperationAdrg());
        drgsEventBus.addObserver(new EventBusMainDiagnosisAdrg());

//        drgsEventBus.addObserver(new EventBusMainDiagnosisAdrg());
//        drgsEventBus.addObserver(new EventBusOperationAdrg());
//        drgsEventBus.addObserver(new EventBusOperatingRoom());
//        drgsEventBus.addObserver(new EventBusAllDiagnosisAdrg());
//        drgsEventBus.addObserver(new EventBusMcc());
//        drgsEventBus.addObserver(new EventBusCc());
//        drgsEventBus.addObserver(new EventBusMdca());
//        drgsEventBus.addObserver(new EventBusMdcp());
//        drgsEventBus.addObserver(new EventBusMdcy());
//        drgsEventBus.addObserver(new EventBusMdczPart());
//        drgsEventBus.addObserver(new EventBusMdcz());
//        drgsEventBus.addObserver(new EventBusAdrgResult());
//        drgsEventBus.addObserver(new EventBusDrgsResult());
//        drgsEventBus.addObserver(new EventBusResult());
        return drgsEventBus;
    }

//    @Bean
//    public EventBus eventBus(){
//        EventBus eventBus =new EventBus();
//        eventBus.register(new EventBusMainDiagnosisAdrg());
//        eventBus.register(new EventBusOperationAdrg());
//        eventBus.register(new EventBusOperatingRoom());
//        eventBus.register(new EventBusAllDiagnosisAdrg());
//        eventBus.register(new EventBusMcc());
//        eventBus.register(new EventBusCc());
//        eventBus.register(new EventBusMdca());
//        eventBus.register(new EventBusMdcp());
//        eventBus.register(new EventBusMdcy());
//        eventBus.register(new EventBusMdczPart());
//        eventBus.register(new EventBusMdcz());
//        eventBus.register(new EventBusAdrgResult());
//        eventBus.register(new EventBusDrgsResult());
//        eventBus.register(new EventBusResult());
//
//        return eventBus;
//    }

}
