package com.example.dbcourse.controller;

import com.example.dbcourse.dao.DiseaseTypeDao;
import com.example.dbcourse.model.DiseaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disease-type")
public class DiseaseTypeController {

    @Autowired
    DiseaseTypeDao diseaseTypeDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("diseaseTypes", diseaseTypeDao.getAll());
        return "disease-type/types";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("type", diseaseTypeDao.getWithId(id));
        return "disease-type/type-edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("type", new DiseaseType());
        return "disease-type/type-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("doctor") DiseaseType diseaseType) {
        diseaseTypeDao.save(diseaseType);
        return "redirect:/disease-type";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        diseaseTypeDao.delete(id);
        return "redirect:/disease-type";
    }
}
