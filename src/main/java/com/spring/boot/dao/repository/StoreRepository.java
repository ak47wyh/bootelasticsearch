package com.spring.boot.dao.repository;

import com.spring.boot.bean.es.Store;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Administrator on 2017/4/24.
 */
public interface StoreRepository extends ElasticsearchRepository<Store,Integer> {
}
