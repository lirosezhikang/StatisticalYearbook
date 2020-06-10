package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    IndexMapper indexMapper;

    @GetMapping("/")
    public String index(@RequestParam(name = "areaSelected",defaultValue = "湖北省") String areaSelected,
                        @RequestParam(name = "yearSelected",defaultValue = "y2019") String yearSelected,
                        Model model) {
        List<String> tableNames=new ArrayList<>();
        tableNames.add("total_value");
        tableNames.add("population");
        tableNames.add("per_value");
        tableNames.add("salary");
        tableNames.add("dis_income");
        tableNames.add("consumption");
        tableNames.add("total_school");
        tableNames.add("edu_fee");

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("total_value","国民生产总值");
        map.put("population","人口");
        map.put("per_value","人均生产总值");
        map.put("salary","人均工资");
        map.put("dis_income","人均可支配收入");
        map.put("consumption","人均消费支出");
        map.put("total_school","高校数");
        map.put("edu_fee","教育经费");

        List<Double> values=new ArrayList<>();
        List<Double> values1=new ArrayList<>();
        List<Map<String,Object>> indicatorValues=new ArrayList<>();

        for(int i=0;i<tableNames.size();i++){
            List<String> columns=indexMapper.columnName(tableNames.get(i));
            for(int j=0;j<columns.size();j++){
                if(yearSelected.equals(columns.get(j))){
                    double value=indexMapper.Query(tableNames.get(i),areaSelected,yearSelected);
                    values.add(value);

                    double value1=indexMapper.Query(tableNames.get(i),"广东省",yearSelected);
                    values1.add(value1);

                    double maxValue=indexMapper.maxData(tableNames.get(i),yearSelected);

                    String title=map.get(tableNames.get(i));

                    HashMap<String,Object> indicatorValue=new HashMap<>();
                    indicatorValue.put("name",title);
                    indicatorValue.put("max",maxValue);
                    indicatorValues.add(indicatorValue);
                }
            }
        }

        model.addAttribute("values",values);
        model.addAttribute("values1",values1);
        model.addAttribute("indicatorValues",indicatorValues);

        return "index";
    }

    @GetMapping("/grid")
    public String grid(@RequestParam(name = "areaSelected",defaultValue = "湖北省") String areaSelected,
                       @RequestParam(name = "yearSelected",defaultValue = "y2019") String yearSelected,
                       Model model){
        List<String> tableNames=new ArrayList<>();
        tableNames.add("total_value");
        tableNames.add("population");
        tableNames.add("per_value");
        tableNames.add("salary");
        tableNames.add("dis_income");
        tableNames.add("consumption");
        tableNames.add("total_school");
        tableNames.add("edu_fee");

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("total_value","国民生产总值");
        map.put("population","人口");
        map.put("per_value","人均生产总值");
        map.put("salary","人均工资");
        map.put("dis_income","人均可支配收入");
        map.put("consumption","人均消费支出");
        map.put("total_school","高校数");
        map.put("edu_fee","教育经费");

        List<Double> values=new ArrayList<>();
        List<Double> values1=new ArrayList<>();
        List<Map<String,Object>> indicatorValues=new ArrayList<>();

        for(int i=0;i<tableNames.size();i++){
            List<String> columns=indexMapper.columnName(tableNames.get(i));
            for(int j=0;j<columns.size();j++){
                if(yearSelected.equals(columns.get(j))){
                    double value=indexMapper.Query(tableNames.get(i),areaSelected,yearSelected);
                    values.add(value);

                    double value1=indexMapper.Query(tableNames.get(i),"广东省",yearSelected);
                    values1.add(value1);

                    double maxValue=indexMapper.maxData(tableNames.get(i),yearSelected);

                    String title=map.get(tableNames.get(i));

                    HashMap<String,Object> indicatorValue=new HashMap<>();
                    indicatorValue.put("name",title);
                    indicatorValue.put("max",maxValue);
                    indicatorValues.add(indicatorValue);
                }
            }
        }

        model.addAttribute("values",values);
        model.addAttribute("values1",values1);
        model.addAttribute("indicatorValues",indicatorValues);

        return "grid-view1";
    }
}
