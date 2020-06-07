package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.mapper.YearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class GetDataYearController {
    @Autowired
    YearMapper yearMapper;

    @GetMapping("/getDataYear")
    @ResponseBody
    public List<Object> getDataYear(@RequestParam(name = "areaSelected") String areaSelected,
                                    @RequestParam(name = "dataSelected") String dataSelected){
        List<String> year=yearMapper.queryYear(dataSelected);
        List<Double> data=yearMapper.queryData(dataSelected,areaSelected);
        List<Object> result=new ArrayList<>();
        result.add(year);
        result.add(data);
        return result;
    }

    @GetMapping("/getDataYear3")
    @ResponseBody
    public List<Object> getDataYear3(@RequestParam(name = "areaSelected1") String areaSelected1,
                                     @RequestParam(name = "areaSelected2") String areaSelected2,
                                    @RequestParam(name = "dataSelected") String dataSelected){
        List<String> year=yearMapper.queryYear(dataSelected);
        List<Double> data1=yearMapper.queryData(dataSelected,areaSelected1);
        List<Double> data2=yearMapper.queryData(dataSelected,areaSelected2);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("total_value1","国民生产总值");
        map.put("population1","人口");
        map.put("per_value1","人均生产总值");
        map.put("salary1","人均工资");
        map.put("dis_income1","人均可支配收入");
        map.put("consumption1","人均消费支出");
        map.put("total_school1","高校数");
        map.put("edu_fee1","教育经费");

        String title=map.get(dataSelected);

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("xizang","西藏");
        map1.put("qinhai","青海");
        map1.put("ningxia","宁夏");
        map1.put("hainan","海南");
        map1.put("gansu","甘肃");
        map1.put("guizhou","贵州");
        map1.put("xinjiang","新疆");
        map1.put("yunnan","云南");
        map1.put("chongqin","重庆");
        map1.put("jilin","吉林");
        map1.put("shanxi","山西");
        map1.put("tianjing","天津");
        map1.put("jiangxi","江西");
        map1.put("guangxi","广西");
        map1.put("shaanxi","陕西");
        map1.put("'heilongjiang","黑龙江");
        map1.put("'neimeng","内蒙古");
        map1.put("anhui","安徽");
        map1.put("beijing","北京");
        map1.put("fujian","福建");
        map1.put("shanghai","上海");
        map1.put("hubei","湖北");
        map1.put("hunan","湖南");
        map1.put("sichuan","四川");
        map1.put("liaoning","辽宁");
        map1.put("hebei","河北");
        map1.put("henan","河南");
        map1.put("zhejiang","浙江");
        map1.put("shandong","山东");
        map1.put("jiangsu","江苏");
        map1.put("guangdong","广东");
        String area1=map1.get(areaSelected1);
        String area2=map1.get(areaSelected2);

        List<Object> result=new ArrayList<>();
        result.add(year);
        result.add(data1);
        result.add(data2);
        result.add(title);
        result.add(area1);
        result.add(area2);
        return result;
    }
}
