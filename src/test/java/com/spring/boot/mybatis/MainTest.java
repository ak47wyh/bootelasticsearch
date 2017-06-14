package com.spring.boot.mybatis;

import com.spring.boot.Application;
import com.spring.boot.bean.es.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MainTest {

  @Autowired
  private UserService userService;

  @Test
  public void test() throws Exception {
//    System.out.println(userService.findAll());
    Iterable<User> users = userService.findAll();
    for(User user:users){
      System.out.println(user);
    }
    System.out.println(users);
  }

  @Test
  public void testsave(){
    User user = new User("wang",12);
    userService.save(user);
    User user1 = new User("wang1",13);
    userService.save(user1);
    User user2 = new User("wang2",14);
    userService.save(user2);
    User user3 = new User("wang3",15);
    userService.save(user3);
  }


}
