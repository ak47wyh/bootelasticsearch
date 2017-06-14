package com.spring.boot.service.impl;

import com.spring.boot.bean.es.Brand;
import com.spring.boot.bean.mybatis.BrandBean;
import com.spring.boot.dao.repository.BrandRepository;
import com.spring.boot.dao.mapper.BrandMapper;
import com.spring.boot.service.BrandService;
import com.spring.boot.utils.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * Created by Administrator on 2017/4/21.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 轮巡生成所有索引数据
     * @param start
     * @param size
     */
    @Override
    public void syncBrandIndex(int start,int size) {

        List<BrandBean> beans = brandMapper.findByPage(start,size);

        List<Brand> brands = new ArrayList<>();
        for(BrandBean bean:beans){
            Brand brand = EntityUtils.transToBrand(bean);
            brands.add(brand);
        }
        if(!CollectionUtils.isEmpty(brands))
        brandRepository.save(brands);

    }

    @Override
    public List<Brand> getBrandAllIndex() {
        Iterable<Brand> brands =  brandRepository.findAll();
        List<Brand> brandList = (List<Brand>) EntityUtils.iterableToList(brands);
        return brandList;
    }

    public List<BrandBean> getAllBrand() {
        List<BrandBean> brandBeans =  brandMapper.findAll();
        return brandBeans;
    }

    @Override
    public List<Brand> findByBrandNm(String brandNm) {
//        QueryBuilder query = QueryBuilders.nestedQuery("Brand",QueryBuilders.boolQuery().must(termQuery("brandNm","")));
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withIndices("Brand")
                .withTypes("Brand")
                .withPageable(new PageRequest(0,1))
                .build();
        Iterable<Brand> brands = brandRepository.search(query);
        List<Brand> brandList = new ArrayList<>();
        brands.forEach(brand -> brandList.add(brand));
        return brandList;
    }

}
