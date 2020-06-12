package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.dao.TableAll;
import com.silence.statisticalyearbook.mapper.ManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/save")
    @ResponseBody
    public void save(@RequestParam(name = "tableName") String tableName,
                     @RequestParam(name = "year") String year,
                     @RequestParam(name = "beijing",defaultValue = "0") double beijing,
                     @RequestParam(name = "tianjing",defaultValue = "0") double tianjing,
                     @RequestParam(name = "hebei",defaultValue = "0") double hebei,
                     @RequestParam(name = "shanxi",defaultValue = "0") double shanxi,
                     @RequestParam(name = "neimeng",defaultValue = "0") double neimeng,
                     @RequestParam(name = "liaoning",defaultValue = "0") double liaoning,
                     @RequestParam(name = "jilin",defaultValue = "0") double jilin,
                     @RequestParam(name = "heilongjiang",defaultValue = "0") double heilongjiang,
                     @RequestParam(name = "shanghai",defaultValue = "0") double shanghai,
                     @RequestParam(name = "jiangsu",defaultValue = "0") double jiangsu,
                     @RequestParam(name = "zhejiang",defaultValue = "0") double zhejiang,
                     @RequestParam(name = "anhui",defaultValue = "0") double anhui,
                     @RequestParam(name = "fujian",defaultValue = "0") double fujian,
                     @RequestParam(name = "jiangxi",defaultValue = "0") double jiangxi,
                     @RequestParam(name = "shandong",defaultValue = "0") double shandong,
                     @RequestParam(name = "henan",defaultValue = "0") double henan,
                     @RequestParam(name = "hubei",defaultValue = "0") double hubei,
                     @RequestParam(name = "hunan",defaultValue = "0") double hunan,
                     @RequestParam(name = "guangdong",defaultValue = "0") double guangdong,
                     @RequestParam(name = "guangxi",defaultValue = "0") double guangxi,
                     @RequestParam(name = "hainan",defaultValue = "0") double hainan,
                     @RequestParam(name = "chongqin",defaultValue = "0") double chongqin,
                     @RequestParam(name = "sichuan",defaultValue = "0") double sichuan,
                     @RequestParam(name = "guizhou",defaultValue = "0") double guizhou,
                     @RequestParam(name = "yunnan",defaultValue = "0") double yunnan,
                     @RequestParam(name = "xizang",defaultValue = "0") double xizang,
                     @RequestParam(name = "shaanxi",defaultValue = "0") double shaanxi,
                     @RequestParam(name = "gansu",defaultValue = "0") double gansu,
                     @RequestParam(name = "qinhai",defaultValue = "0") double qinhai,
                     @RequestParam(name = "ningxia",defaultValue = "0") double ningxia,
                     @RequestParam(name = "xinjiang",defaultValue = "0") double xinjiang
                     ){

        TableAll tableAll=new TableAll();
        tableAll.setYear(year);
        tableAll.setBeijing(beijing);
        tableAll.setTianjing(tianjing);
        tableAll.setHebei(hebei);
        tableAll.setShanxi(shanxi);
        tableAll.setNeimeng(neimeng);
        tableAll.setLiaoning(liaoning);
        tableAll.setJilin(jilin);
        tableAll.setHeilongjiang(heilongjiang);
        tableAll.setShanghai(shanghai);
        tableAll.setJiangsu(jiangsu);
        tableAll.setZhejiang(zhejiang);
        tableAll.setAnhui(anhui);
        tableAll.setFujian(fujian);
        tableAll.setJiangxi(jiangxi);
        tableAll.setShandong(shandong);
        tableAll.setHenan(henan);
        tableAll.setHubei(hubei);
        tableAll.setHunan(hunan);
        tableAll.setGuangdong(guangdong);
        tableAll.setGuangxi(guangxi);
        tableAll.setHainan(hainan);
        tableAll.setChongqin(chongqin);
        tableAll.setSichuan(sichuan);
        tableAll.setGuizhou(guizhou);
        tableAll.setYunnan(yunnan);
        tableAll.setXizang(xizang);
        tableAll.setShaanxi(shaanxi);
        tableAll.setGansu(gansu);
        tableAll.setQinhai(qinhai);
        tableAll.setNingxia(ningxia);
        tableAll.setXinjiang(xinjiang);

        Integer flag=manageMapper.hasData(year,tableName);
        if(flag>0){
            manageMapper.updateRow(tableAll,tableName);
        }else {
            manageMapper.addRow(tableAll,tableName);
        }
    }

    @GetMapping("/delete")
    @ResponseBody
    public Integer delete(@RequestParam(name = "tableName") String tableName,
                       @RequestParam(name = "year") String year){

        Integer flag=manageMapper.hasData(year,tableName);
        if(flag>0){
            manageMapper.delete(year,tableName);
            return 1;
        }else {
            return 0;
        }
    }
}
