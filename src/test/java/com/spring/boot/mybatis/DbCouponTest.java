package com.spring.boot.mybatis;

import com.spring.boot.Application;
import com.spring.boot.bean.mybatis.BrandBean;
import com.spring.boot.bean.mybatis.CouponBean;
import com.spring.boot.dao.mapper.BrandMapper;
import com.spring.boot.dao.mapper.CouponMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/4/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DbCouponTest {
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CouponMapper couponMapper;

    @Test
    public void testQueryCoupon(){
        CouponBean bean = couponMapper.findById("D00000000091296");
        System.out.println(bean);
    }

    @Test
    public void testSave(){
       BrandBean brand = brandMapper.findByBrandNm("家乐福");
//        BrandBean brand = brandMapper.findById("8");
       System.out.println(brand);

        /*List<BrandBean> brandBeans = brandMapper.findAll();
        for(BrandBean bean:brandBeans){
            System.out.println(bean);
        }*/
    }
}
