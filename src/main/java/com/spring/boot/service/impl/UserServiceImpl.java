package com.spring.boot.service.impl;

import com.spring.boot.bean.es.User;
import com.spring.boot.dao.repository.UserRepository;
import com.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public Iterable<User> findAll() {
    return userRepository.findAll();
  }

}
