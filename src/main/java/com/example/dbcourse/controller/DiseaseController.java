package com.example.dbcourse.controller;

import com.example.dbcourse.dao.DiseaseDao;
import com.example.dbcourse.model.Disease;
import com.example.dbcourse.model.Doctor;
import com.example.dbcourse.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disease")
public class DiseaseController {

    @Autowired
    DiseaseDao diseaseDao;
    @Autowired
    AppService service;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("diseases", diseaseDao.getAll());
        return "disease/diseases";
    }

    @GetMapping("/edit/{code}")
    public String edit(@PathVariable("code") String code, Model model) {
        model.addAttribute("disease", diseaseDao.getWithCode(code));
        return "disease/disease-edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("disease", new Disease());
        return "disease/disease-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("disease") Disease disease) {
        service.saveDisease(disease);
        return "redirect:/disease";
    }

    @PostMapping("/delete/{code}")
    public String delete(@PathVariable("code") String code) {
        diseaseDao.delete(code);
        return "redirect:/disease";
    }
}
