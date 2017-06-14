package com.spring.boot.service.impl;

import com.spring.boot.bean.es.Store;
import com.spring.boot.bean.mybatis.StoreBean;
import com.spring.boot.dao.repository.StoreRepository;
import com.spring.boot.dao.mapper.StoreMapper;
import com.spring.boot.service.StoreService;
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
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private StoreRepository storeRepository;

    public void syncStoreIndex(int start,int size){
        List<StoreBean> beans = storeMapper.findByPage(start,size);

        List<Store> sotres = new ArrayList<Store>();
        for(StoreBean bean:beans){
            Store store = EntityUtils.transToStore(bean);
            sotres.add(store);
        }
        if(!CollectionUtils.isEmpty(sotres))
        storeRepository.save(sotres);
    }
}
