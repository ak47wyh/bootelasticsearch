package com.spring.boot.control;

import com.spring.boot.bean.es.Brand;
import com.spring.boot.bean.mybatis.BrandBean;
import com.spring.boot.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 */
@Api(basePath = "/brand", value = "brand", description = "brand description ", produces = "application/json")
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "get all brandBean",notes = "return brandbean List")
    @RequestMapping(value = {"bean/all"}, method = RequestMethod.GET)
    public List<BrandBean> getAllBrand(){
        List<BrandBean> brandList = brandService.getAllBrand();
        return brandList;
    }

    @ApiOperation(value = "get all brand Index.",notes = "return all brand index.")
    @RequestMapping(value = {"index/all"}, method = RequestMethod.GET)
    public List<Brand> getBrandAllIndex(){
        List<Brand> brandList = brandService.getBrandAllIndex();
        return brandList;
    }



}
