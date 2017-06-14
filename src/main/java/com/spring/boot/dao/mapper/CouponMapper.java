package com.spring.boot.dao.mapper;

import com.spring.boot.bean.mybatis.CouponBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */
@Mapper
public interface CouponMapper {

    @Results(id = "coupon", value = {
            @Result(property = "couponNo", column = "coupon_no", id = true),
            @Result(property = "couponNm", column = "coupon_nm"),
            @Result(property = "couponType", column = "coupon_type"),
            @Result(property = "couponIntro", column = "coupon_intro"),
            @Result(property = "couponImg", column = "coupon_img"),
            @Result(property = "couponImgDesc", column = "coupon_img_desc"),
            @Result(property = "addDate", column = "add_date"),
            @Result(property = "effectiveDate", column = "effective_date"),
            @Result(property = "expiryDate", column = "expiry_date"),
            @Result(property = "downStartTs", column = "down_start_ts"),
            @Result(property = "downEndTs", column = "down_end_ts"),
            @Result(property = "rowCrtUsr", column = "crt_usr_id"),
            @Result(property = "rowCrtTs", column = "crt_ts"),
            @Result(property = "recUpdusr", column = "upd_usr_id"),
            @Result(property = "recUpdTs", column = "upd_ts"),
            @Result(property = "organCode", column = "organ_code"),
            @Result(property = "status", column = "status")
    })
    @Select("SELECT * from coupon where coupon_no= #{couponNo}")
    CouponBean findById(@Param("couponNo")String couponNo);

    @ResultMap("coupon")
    @Select("SELECT * from coupon limit #{start},#{size}")
    List<CouponBean> findByPage(@Param("start")int start, @Param("size")int size);
}
