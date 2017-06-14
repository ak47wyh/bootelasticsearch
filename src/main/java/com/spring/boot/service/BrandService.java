package com.spring.boot.service;

import com.spring.boot.bean.es.Brand;
import com.spring.boot.bean.mybatis.BrandBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/21.
 */
public interface BrandService {

    void syncBrandIndex(int start,int size);

    List<Brand> getBrandAllIndex();

    List<BrandBean> getAllBrand();

    List<Brand> findByBrandNm(String brandNm);
}
