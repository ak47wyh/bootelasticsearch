package com.spring.boot.service.impl;

import com.spring.boot.bean.es.Coupon;
import com.spring.boot.bean.mybatis.CouponBean;
import com.spring.boot.dao.repository.CouponRepository;
import com.spring.boot.dao.mapper.CouponMapper;
import com.spring.boot.service.CouponService;
import com.spring.boot.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private CouponRepository couponRepository;

    public void syncCouponIndex(int start,int size){
        List<CouponBean> beans = couponMapper.findByPage(start,size);

        List<Coupon> coupons = new ArrayList<Coupon>();
        for(CouponBean bean:beans){
            Coupon coupon = EntityUtils.transToCoupon(bean);
            coupons.add(coupon);
        }
        if(!CollectionUtils.isEmpty(coupons))
        couponRepository.save(coupons);
    };

}
