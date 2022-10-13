package com.branch.branchhomework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.branch.branchhomework.domain.UserDto;
import com.branch.branchhomework.services.UserService;

@RestController
public class UserController {

  UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/api/v1/users/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable String id) throws Exception {
    return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
  }

}
