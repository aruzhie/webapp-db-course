package com.example.dbcourse.controller;

import com.example.dbcourse.dao.CountryDao;
import com.example.dbcourse.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryDao countryDao;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("countries", countryDao.getAll());
        return "country/country";
    }

    @GetMapping("/edit/{cname}")
    public String edit(@PathVariable("cname") String cname, Model model) {
        model.addAttribute("country", countryDao.getWithName(cname));
        return "country/country-edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("country", new Country());
        return "country/country-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("country") Country country) {
        countryDao.save(country);
        return "redirect:/country";
    }

    @PostMapping("/delete/{cname}")
    public String delete(@PathVariable("cname") String cname) {
        countryDao.delete(cname);
        return "redirect:/country";
    }

}
