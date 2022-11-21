package com.example.dbcourse.controller;

import com.example.dbcourse.dao.RecordDao;
import com.example.dbcourse.model.Record;
import com.example.dbcourse.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordDao recordDao;
    @Autowired
    AppService service;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("records", recordDao.getAll());
        return "record/records";
    }

    @GetMapping("/edit/{email}/{cname}/{diseaseCode}")
    public String edit(@PathVariable("email") String email, @PathVariable("cname") String cname, @PathVariable("diseaseCode") String diseaseCode, Model model) {
        model.addAttribute("record", recordDao.getWith(email, cname, diseaseCode));
        return "record/record-edit";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("record", new Record());
        return "record/record-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("record") Record record) {
        service.saveRecord(record);
        return "redirect:/record";
    }

    @PostMapping("/delete/{email}/{cname}/{diseaseCode}")
    public String delete(@PathVariable("email") String email, @PathVariable("cname") String cname, @PathVariable("diseaseCode") String diseaseCode) {
        recordDao.delete(email, cname, diseaseCode);
        return "redirect:/record";
    }
}
