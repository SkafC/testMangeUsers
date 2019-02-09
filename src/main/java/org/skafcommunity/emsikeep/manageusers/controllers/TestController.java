package org.skafcommunity.emsikeep.manageusers.controllers;


import org.skafcommunity.emsikeep.manageusers.models.User;
import org.skafcommunity.emsikeep.manageusers.services.TestServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testAPI")
public class TestController {


  @RequestMapping("/users")
  public List<User> getAllUsers(){
    return TestServices.getUsers();
  }
}
