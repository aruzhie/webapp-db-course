package com.example.dbcourse.controller;

import com.example.dbcourse.dao.DoctorDao;
import com.example.dbcourse.model.Doctor;
import com.example.dbcourse.model.User;
import com.example.dbcourse.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorDao doctorDao;
    @Autowired
    AppService service;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("doctors", doctorDao.getAll());
        return "doctor/doctors";
    }

    @GetMapping("/edit/{email}")
    public String edit(@PathVariable("email") String email, Model model) {
        model.addAttribute("doctor", doctorDao.getWithEmail(email));
        return "doctor/doctor-edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/doctor-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("doctor") Doctor doctor) {
        service.saveDoctor(doctor);
        return "redirect:/doctor";
    }

    @PostMapping("/delete/{email}")
    public String delete(@PathVariable("email") String email) {
        doctorDao.delete(email);
        return "redirect:/doctor";
    }
}
