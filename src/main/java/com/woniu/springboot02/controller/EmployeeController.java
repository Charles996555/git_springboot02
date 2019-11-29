package com.woniu.springboot02.controller;

import com.woniu.springboot02.dao.EmployeeDao;
import com.woniu.springboot02.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("emps")
    public String list(Model model){

        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        System.out.println("udhosihgosid");
        return "emp/list";
    }

}
