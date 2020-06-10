package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.dao.TableAll;
import com.silence.statisticalyearbook.mapper.ManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ManageController {

    @Autowired
    ManageMapper manageMapper;

    @GetMapping("/manage")
    public String manage(@RequestParam(name = "tableSelected",defaultValue = "total_value1") String tableName,
                         Model model) {
        List<TableAll> result=manageMapper.queryAll(tableName);
        model.addAttribute("result",result);
        return "manage";
    }

    @GetMapping("/tableData")
    @ResponseBody
    public List<TableAll> tableData(@RequestParam(name = "tableSelected",defaultValue = "total_value1") String tableName){
        List<TableAll> result=manageMapper.queryAll(tableName);
        return result;
    }
}
