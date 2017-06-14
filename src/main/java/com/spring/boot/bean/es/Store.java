package com.spring.boot.bean.es;

import com.alibaba.fastjson.JSON;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/24.
 */
@Document(indexName = "store", type = "store", shards = 1, replicas = 0,refreshInterval = "-1")
public class Store {

    @Id
    private int storeId;
    private String storeNm;
    private String storeAddr;
    private String cityCode;
    private String busiHours;//营业时间
    private String contactPhone;
    private String lng;
    private String lat;
    private String crtUsrId;
    private Date crtTs;
    private String updUsrId;
    private Date updTs;
    private String status;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreNm() {
        return storeNm;
    }

    public void setStoreNm(String storeNm) {
        this.storeNm = storeNm;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getBusiHours() {
        return busiHours;
    }

    public void setBusiHours(String busiHours) {
        this.busiHours = busiHours;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
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
