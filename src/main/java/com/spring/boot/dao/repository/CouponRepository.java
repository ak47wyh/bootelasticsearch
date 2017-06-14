package com.spring.boot.dao.repository;

import com.spring.boot.bean.es.Coupon;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface CouponRepository extends ElasticsearchRepository<Coupon,String> {
}
