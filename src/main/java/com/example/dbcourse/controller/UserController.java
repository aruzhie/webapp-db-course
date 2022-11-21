package com.example.dbcourse.controller;

import com.example.dbcourse.dao.UserDao;
import com.example.dbcourse.model.User;
import com.example.dbcourse.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;
    @Autowired
    AppService service;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDao.getAll());
        return "user/users";
    }

    @GetMapping("/edit/{email}")
    public String edit(@PathVariable("email") String email, Model model) {
        model.addAttribute("user", userDao.getWithEmail(email));
        return "user/user-edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user/user-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        service.saveUser(user);
        return "redirect:/user";
    }

    @PostMapping("/delete/{email}")
    public String delete(@PathVariable("email") String email) {
        userDao.delete(email);
        return "redirect:/user";
    }

}
