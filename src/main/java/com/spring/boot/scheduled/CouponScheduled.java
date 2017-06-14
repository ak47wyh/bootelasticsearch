package com.spring.boot.scheduled;

import com.spring.boot.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/4/21.
 */
@Component
public class CouponScheduled {

    @Autowired
    private CouponService couponService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void syncCouponIndex(){
        couponService.syncCouponIndex(0,10);
    }
}
