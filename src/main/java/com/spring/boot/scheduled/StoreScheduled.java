package com.spring.boot.scheduled;

import com.spring.boot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/4/21.
 */
@Component
public class StoreScheduled {

    @Autowired
    private StoreService storeService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void syncStoreIndex(){
        storeService.syncStoreIndex(0,10);
    }
}
