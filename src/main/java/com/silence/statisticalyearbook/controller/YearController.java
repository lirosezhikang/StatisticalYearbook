package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.dao.yearData;
import com.silence.statisticalyearbook.mapper.YearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class YearController {

    @Autowired
    YearMapper yearMapper;

    @GetMapping("/year")
    public String year(@RequestParam(name = "areaSelected1",defaultValue = "guangdong") String areaSelected1,
                       @RequestParam(name = "areaSelected2",defaultValue = "hubei") String areaSelected2,
                       @RequestParam(name = "dataSelected",defaultValue = "total_value1") String dataSelected,
                       Model model){
        List<String> year=yearMapper.queryYear(dataSelected);
        List<Double> data1=yearMapper.queryData(dataSelected,areaSelected1);
        List<Double> data2=yearMapper.queryData(dataSelected,areaSelected2);

        model.addAttribute("year",year);
        model.addAttribute("data1",data1);
        model.addAttribute("data2",data2);
        return "year";
    }
}
