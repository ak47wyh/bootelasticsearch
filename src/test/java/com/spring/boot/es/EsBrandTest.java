package com.spring.boot.es;

import com.spring.boot.Application;
import com.spring.boot.bean.es.Brand;
import com.spring.boot.bean.mybatis.BrandBean;
import com.spring.boot.dao.repository.BrandRepository;
import com.spring.boot.dao.mapper.BrandMapper;
import com.spring.boot.utils.EntityUtils;
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
public class EsBrandTest {

    @Autowired
    private BrandRepository repository;

    @Autowired
    private BrandMapper brandMapper;

    @Test
    public void testSaveBrand(){
        BrandBean bean = brandMapper.findById("8");
        Brand brand = EntityUtils.transToBrand(bean);
        repository.save(brand);
    }

    @Test
    public void testQueryBrand(){
        Iterable<Brand> brands = repository.findAll();
        for (Brand brand:brands){
            System.out.println(brand);
        }
    }
}
