package com.spring.boot.scheduled;

import com.spring.boot.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/4/21.
 */
@Component
public class BrandScheduled {

    @Autowired
    private BrandService brandService;

    @Scheduled(cron = "0/30 * * * * ?")
    public void syncBrandIndex(){
        brandService.syncBrandIndex(0,10);
    }
}
