package com.silence.statisticalyearbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AreaController {
    @GetMapping("/area")
    public String Area(){
        return "area";
    }
}
