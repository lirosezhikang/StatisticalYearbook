package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginMapper loginMapper;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/prove")
    public String prove(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        HttpSession session,
                        Model model){
        String rightPassword=loginMapper.queryPassword(username);
        if(rightPassword==null){
            model.addAttribute("error","用户名密码错误");
            return "login";
        }else {
            if(rightPassword.equals(password)){
                session.setAttribute("username",username);
                return "redirect:/";
            }
            else {
                model.addAttribute("error","用户名密码错误");
                return "login";
            }
        }

    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request,
                         HttpServletRequest response){
        request.getSession().removeAttribute("username");

        return "redirect:/";
    }
}
