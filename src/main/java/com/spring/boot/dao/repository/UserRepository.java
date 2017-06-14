package com.spring.boot.dao.repository;

import com.spring.boot.bean.es.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, Long> {

}
