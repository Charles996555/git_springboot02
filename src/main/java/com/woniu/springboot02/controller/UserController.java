package com.woniu.springboot02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(String username, String password, Map<String,Object> map, HttpSession session){
        map.put("msg","用户名或者密码错误");
        if (username!=null&&password.equals("000000")){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        return "login";
    }
}
