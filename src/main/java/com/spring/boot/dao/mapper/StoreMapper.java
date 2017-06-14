package com.spring.boot.dao.mapper;

import com.spring.boot.bean.mybatis.StoreBean;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */
@Mapper
@CacheConfig(cacheNames = "store")
public interface StoreMapper {

    @Results(id = "store",value = {
            @Result(property = "storeId", column = "store_id", id = true),
            @Result(property = "storeNm", column = "store_nm"),
            @Result(property = "storeAddr", column = "store_addr"),
            @Result(property = "cityCode", column = "city_code"),
            @Result(property = "busiHours", column = "busi_hours"),
            @Result(property = "contactPhone", column = "contact_phone"),
            @Result(property = "lng", column = "lng"),
            @Result(property = "lat", column = "lat"),
            @Result(property = "crtUsrId", column = "crt_usr_id"),
            @Result(property = "crtTs", column = "crt_ts"),
            @Result(property = "updUsrId", column = "upd_usr_id"),
            @Result(property = "updTs", column = "upd_ts"),
            @Result(property = "status", column = "status")
    })
    @Select("select * from store limit #{start},#{size}")
    @Cacheable(key = "#p0")
    List<StoreBean> findByPage(@Param("start")int start, @Param("size") int size);
}
