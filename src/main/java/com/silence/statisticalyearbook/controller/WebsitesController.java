package com.silence.statisticalyearbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsitesController {

    @GetMapping("/websites")
    public String websites(){
        return "websites";
    }
}
