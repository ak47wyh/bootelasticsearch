package com.spring.boot.service;

import com.spring.boot.bean.es.User;


public interface UserService {
  void save(User user);

  Iterable<User> findAll();
}
