package main.java.com.Projekt.PDFWriter.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.com.Projekt.PDFWriter.Klassen.UserInfo;
import main.java.com.Projekt.PDFWriter.Klassen.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getUsers(Model model) {
    List<UserInfo> users = userService.getUsers();
    model.addAttribute("user", users);
    model.addAttribute("userInfo", new UserInfo());
    return "user";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String createUser(Model model, @ModelAttribute UserInfo userInfo) {
    UserInfo user = userService.createUser(userInfo);
    return "redirect:/user/";
  }
}
