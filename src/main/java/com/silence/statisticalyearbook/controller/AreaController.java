package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.dao.AreaData;
import com.silence.statisticalyearbook.dao.TableAll;
import com.silence.statisticalyearbook.mapper.AreaMapper;
import com.silence.statisticalyearbook.mapper.ManageMapper;
import com.silence.statisticalyearbook.mapper.YearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class AreaController {

    @Autowired
    AreaMapper areaMapper;

    @Autowired
    ManageMapper manageMapper;

    @GetMapping("/area")
    public String Area(@RequestParam(name = "dataSelected",defaultValue = "total_value") String dataSelected,
                       @RequestParam(name = "yearSelected",defaultValue = "y2019") String yearSelected,
                       Model model){
        AreaData maxAreaData =areaMapper.maxQuery(dataSelected, yearSelected);
        AreaData minAreaData =areaMapper.minQuery(dataSelected, yearSelected);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("total_value","国民生产总值");
        map.put("population","人口");
        map.put("per_value","人均生产总值");
        map.put("salary","人均工资");
        map.put("dis_income","人均可支配收入");
        map.put("consumption","人均消费支出");
        map.put("total_school","高校数");
        map.put("edu_fee","教育经费");

        String title=map.get(dataSelected);

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("total_value","(亿元)");
        map2.put("population","(万人)");
        map2.put("per_value","(元)");
        map2.put("salary","(元)");
        map2.put("dis_income","(元)");
        map2.put("consumption","(元)");
        map2.put("total_school","(所)");
        map2.put("edu_fee","(万元)");
        String unit=map2.get(dataSelected);

        model.addAttribute("dataSelected",dataSelected);
        model.addAttribute("yearSelected",yearSelected);
        model.addAttribute("maxValue", maxAreaData);
        model.addAttribute("minValue",minAreaData);
        model.addAttribute("title",title);
        model.addAttribute("unit",unit);
        return "area";
    }

    @GetMapping("/grid2")
    public String grid2(@RequestParam(name = "tableSelected",defaultValue = "total_value1") String tableName,
                        Model model){
        List<TableAll> result=manageMapper.queryAll(tableName);
        model.addAttribute("result",result);
        return "grid-view2";
    }


}
