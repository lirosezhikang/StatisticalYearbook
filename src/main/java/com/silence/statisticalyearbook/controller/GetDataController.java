package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.dao.Echarts;
import com.silence.statisticalyearbook.dao.AreaData;
import com.silence.statisticalyearbook.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class GetDataController {
    @Autowired
    AreaMapper areaMapper;

    @GetMapping("/getData")
    @ResponseBody
    public List<Object> getData(@RequestParam(name = "dataSelected",defaultValue = "total_value") String dataSelected,
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

        List<Object> result=new ArrayList<>();


        List<AreaData> areaDataList= areaMapper.areaQuery(dataSelected, yearSelected);
        List<Echarts> echartsList=new ArrayList<>();

        for(int i=0;i<areaDataList.size();i++){
            Echarts echarts=new Echarts();
            echarts.setName(areaDataList.get(i).getAreaName());
            echarts.setValue(areaDataList.get(i).getData());
            echartsList.add(echarts);
        }


        model.addAttribute("areaDataList",areaDataList);

        result.add(0,echartsList);
        result.add(1,maxAreaData);
        result.add(2,minAreaData);
        result.add(3,title);
        result.add(4,unit);

        return result;
    }
}
