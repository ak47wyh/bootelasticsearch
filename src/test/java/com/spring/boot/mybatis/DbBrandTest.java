package com.spring.boot.mybatis;

import com.spring.boot.Application;
import com.spring.boot.bean.mybatis.BrandBean;
import com.spring.boot.dao.mapper.BrandMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/4/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DbBrandTest {

    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void testQueryBrand(){
        BrandBean bean = brandMapper.findById("8");

//        Mockito.when(brandMapper.findById("1")).thenReturn(bean);
        System.out.println(bean);
    }

}
