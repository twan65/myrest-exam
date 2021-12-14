package org.myrest.web.controller;

import lombok.RequiredArgsConstructor;
import org.myrest.web.model.User;
import org.myrest.web.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/account")
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/login")
  public String getLogin() {
    return "account/login";
  }

  @GetMapping("/register")
  public String getRegister() {
    return "account/register";
  }

  @PostMapping("/register")
  public String postRegister(User user) {
    accountService.save(user);
    return "redirect:/";
  }

}
