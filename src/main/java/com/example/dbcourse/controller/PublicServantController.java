package com.example.dbcourse.controller;

import com.example.dbcourse.dao.PublicServantDao;
import com.example.dbcourse.model.PublicServant;
import com.example.dbcourse.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/public-servant")
public class PublicServantController {

    @Autowired
    PublicServantDao publicServantDao;
    @Autowired
    AppService service;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("servants", publicServantDao.getAll());
        return "public-servant/servants";
    }

    @GetMapping("/edit/{email}")
    public String edit(@PathVariable("email") String email, Model model) {
        model.addAttribute("servant", publicServantDao.getWithEmail(email));
        return "public-servant/servant-edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("servant", new PublicServant());
        return "public-servant/servant-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("doctor") PublicServant publicServant) {
        service.savePublicServant(publicServant);
        return "redirect:/public-servant";
    }

    @PostMapping("/delete/{email}")
    public String delete(@PathVariable("email") String email) {
        publicServantDao.delete(email);
        return "redirect:/public-servant";
    }
}
