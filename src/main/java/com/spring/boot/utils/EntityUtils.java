package com.spring.boot.utils;

import com.spring.boot.bean.es.Brand;
import com.spring.boot.bean.es.Coupon;
import com.spring.boot.bean.es.Store;
import com.spring.boot.bean.mybatis.BrandBean;
import com.spring.boot.bean.mybatis.CouponBean;
import com.spring.boot.bean.mybatis.StoreBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */
public class EntityUtils {

    public static Brand transToBrand(BrandBean bean){

        Brand brand = new Brand();
        brand.setBrandId(bean.getBrandId());
        brand.setBrandNm(bean.getBrandNm());
        brand.setBrandDesc(bean.getBrandDesc());
        brand.setBrandHistory(bean.getBrandHistory());
        brand.setBrandImg(bean.getBrandImg());
        brand.setBrandImgDesc(bean.getBrandImgDesc());
        brand.setCrtUsrId(bean.getCrtUsrId());
        brand.setCrtTs(bean.getCrtTs());
        brand.setUpdUsrId(bean.getUpdUsrId());
        brand.setUpdTs(bean.getUpdTs());
        return brand;
    }

    public static Store transToStore(StoreBean bean){

        Store store = new Store();
        store.setStoreId(bean.getStoreId());
        store.setStoreNm(bean.getStoreNm());
        store.setStoreAddr(bean.getStoreAddr());
        store.setLng(bean.getLng());
        store.setLat(bean.getLat());
        store.setCrtUsrId(bean.getCrtUsrId());
        store.setCrtTs(bean.getCrtTs());
        store.setUpdUsrId(bean.getUpdUsrId());
        store.setUpdTs(bean.getUpdTs());
        return store;
    }

    public static Coupon transToCoupon(CouponBean bean){
        Coupon coupon = new Coupon();
        coupon.setCouponNo(bean.getCouponNo());

        return coupon;
    }

    /**
     * 将迭代器转化成集合
     * @param iterable
     * @return
     */
    public static List iterableToList(Iterable iterable){
        List list = new ArrayList();
        if(iterable!=null){
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()){
                list.add(iterator.next());
            }
        }
        return list;
    }
}
