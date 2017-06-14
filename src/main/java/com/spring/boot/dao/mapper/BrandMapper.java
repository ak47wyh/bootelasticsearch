package com.spring.boot.dao.mapper;

import com.spring.boot.bean.mybatis.BrandBean;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */
@Mapper
@CacheConfig(cacheNames = "BrandBeans")
public interface BrandMapper {

    @ResultMap("brand")
    @Select("select * from brand where brand_Nm = #{brandNm} limit 1")
    @Cacheable(key = "#p0")
    BrandBean findByBrandNm(@Param("brandNm")String name);

    @ResultMap("brand")
    @Select("select * from brand where brand_id = #{brandId} ")
    @Cacheable(key = "#p0")
    BrandBean findById(@Param("brandId")String brandId);

    @ResultMap("brand")
    @Select("select * from brand order by upd_ts limit #{start},#{size}")
    @Cacheable(key = "#p0")
    List<BrandBean> findByPage(@Param("start")int start,@Param("size")int size);

    @CachePut(key = "#p0.brandId")
    BrandBean save(BrandBean bean);

    @Results(id = "brand",value = {
            @Result(property = "brandId",column = "brand_id", id = true),
            @Result(property = "brandNm", column = "brand_nm"),
            @Result(property = "brandDesc", column = "brand_desc"),
            @Result(property = "brandHistory",column = "brand_story"),
            @Result(property = "brandImg", column = "brand_img"),
            @Result(property = "brandImgDesc",column = "brand_img_desc"),
            @Result(property = "crtUsrId", column = "crt_usr_id"),
            @Result(property = "crtTs", column = "crt_ts"),
            @Result(property = "updUsrId", column = "upd_usr_id"),
            @Result(property = "updTs", column = "upd_ts"),
            @Result(property = "status", column = "status")


    })
    @Select("select * from brand ")
    @Cacheable(key = "#p0")
    List<BrandBean> findAll();

}
