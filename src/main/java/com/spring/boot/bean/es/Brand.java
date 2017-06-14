package com.spring.boot.bean.es;


import com.alibaba.fastjson.JSON;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/31.
 */
@Document(indexName = "brand", type = "brand", shards = 1, replicas = 0, refreshInterval = "-1")
public class Brand {
    @Id
    private int brandId;
    private String brandNm;
    private String brandDesc;
    private String brandHistory;
    private String brandImg;
    private String brandImgDesc;
    private String crtUsrId;
    private Date crtTs;
    private String updUsrId;
    private Date updTs;
    private String status;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandNm() {
        return brandNm;
    }

    public void setBrandNm(String brandNm) {
        this.brandNm = brandNm;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public String getBrandHistory() {
        return brandHistory;
    }

    public void setBrandHistory(String brandHistory) {
        this.brandHistory = brandHistory;
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    public String getBrandImgDesc() {
        return brandImgDesc;
    }

    public void setBrandImgDesc(String brandImgDesc) {
        this.brandImgDesc = brandImgDesc;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
