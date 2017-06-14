package com.spring.boot.dao.repository;

import com.spring.boot.bean.es.Brand;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface BrandRepository extends ElasticsearchRepository<Brand,Integer> {


    @Query("{\"bool\":{\"must\":{\"brandNm\":?0}}}")
    public List<Brand> findByBrandNm(String brandNm);
}
