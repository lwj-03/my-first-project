package com.stbu.controller;

import com.stbu.controller.bean.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(types = MyUser.class)
public class MyController {
    @GetMapping("/hi")
    public String hi() {
        return "welcome.jsp";
    }
    @GetMapping("/toReg")
    public String toReg() {
        return "reg.jsp";
    }
    @PostMapping("/reg")
    public String regHandle(@RequestParam("username") String username,
                            @RequestParam("pwd") String password,
                            Model model) {
        MyUser myUser = new MyUser();
        myUser.setUsername(username);
        myUser.setPassword(password);
        model.addAttribute("myUser", myUser);
        return "forward:/toLogin";
    }
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login.jsp";
    }
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("pwd") String password,
                              @SessionAttribute("myUser") MyUser myUser, ModelAndView mv) {

        String result = "";
        if (username != null && password != null &&
                myUser != null &&
                username.equals(myUser.getUsername()) &&
                password.equals(myUser.getPassword())) {
            result = username + ":登录成功";
        } else {
            result = "登录失败";
        }

        mv.addObject("msg", result);
        mv.setViewName("info.jsp");
        return mv;
    }
}