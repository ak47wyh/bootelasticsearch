package com.spring.boot.control;

import com.spring.boot.bean.es.User;
import com.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/es/")
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping("/list")
  public Iterable<User> list() {
    userService.save(new User("ddd", 33));
    return userService.findAll();
  }
}
