package com.spring.boot.bean.es;

import com.alibaba.fastjson.JSON;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/12.
 */
@Document(indexName = "coupon", type = "coupon", shards = 1, replicas = 0, refreshInterval = "-1")
public class Coupon {
    @Id
    private String couponNo;
    private String couponNm;
    private String couponType;
    private String couponIntro;
    private String couponImg;
    private String couponImgDesc;
    private Date addDate;//上架日期
    private Date effectiveDate;//生效日期
    private Date expiryDate;//失效日期
    private Date downStartTs;//下载开始日期
    private Date downEndTs;//下载截止日期
    private String crtUsrId;
    private Date crtTs;
    private String updUsrId;
    private Date updTs;
    private String organCode;//发布优惠的机构
    private String status;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getCouponNm() {
        return couponNm;
    }

    public void setCouponNm(String couponNm) {
        this.couponNm = couponNm;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCouponIntro() {
        return couponIntro;
    }

    public void setCouponIntro(String couponIntro) {
        this.couponIntro = couponIntro;
    }

    public String getCouponImg() {
        return couponImg;
    }

    public void setCouponImg(String couponImg) {
        this.couponImg = couponImg;
    }

    public String getCouponImgDesc() {
        return couponImgDesc;
    }

    public void setCouponImgDesc(String couponImgDesc) {
        this.couponImgDesc = couponImgDesc;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDownStartTs() {
        return downStartTs;
    }

    public void setDownStartTs(Date downStartTs) {
        this.downStartTs = downStartTs;
    }

    public Date getDownEndTs() {
        return downEndTs;
    }

    public void setDownEndTs(Date downEndTs) {
        this.downEndTs = downEndTs;
    }

    public String getCrtUsrId() {
        return crtUsrId;
    }

    public void setCrtUsrId(String crtUsrId) {
        this.crtUsrId = crtUsrId;
    }

    public Date getCrtTs() {
        return crtTs;
    }

    public void setCrtTs(Date crtTs) {
        this.crtTs = crtTs;
    }

    public String getUpdUsrId() {
        return updUsrId;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public Date getUpdTs() {
        return updTs;
    }

    public void setUpdTs(Date updTs) {
        this.updTs = updTs;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
