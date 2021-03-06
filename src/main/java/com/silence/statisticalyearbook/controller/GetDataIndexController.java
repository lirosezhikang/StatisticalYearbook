package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GetDataIndexController {
    @Autowired
    IndexMapper indexMapper;

    @GetMapping("/getDataIndex")
    @ResponseBody
    public List<Object> getDataIndex(@RequestParam(name = "areaSelected") String areaSelected,
                                     @RequestParam(name = "yearSelected") String yearSelected) {

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
        List<Map<String,Object>> indicatorValues=new ArrayList<>();

        for(int i=0;i<tableNames.size();i++){
            List<String> columns=indexMapper.columnName(tableNames.get(i));
            for(int j=0;j<columns.size();j++){
                if(yearSelected.equals(columns.get(j))){
                    double value=indexMapper.Query(tableNames.get(i),areaSelected,yearSelected);
                    values.add(value);

                    double maxValue=indexMapper.maxData(tableNames.get(i),yearSelected);

                    String title=map.get(tableNames.get(i));

                    HashMap<String,Object> indicatorValue=new HashMap<>();
                    indicatorValue.put("name",title);
                    indicatorValue.put("max",maxValue);
                    indicatorValues.add(indicatorValue);
                }
            }
        }

        List<Object> result=new ArrayList<>();
        result.add(values);
        result.add(indicatorValues);
        result.add(areaSelected);


        return result;
    }

    @GetMapping("/getDataIndex3")
    @ResponseBody
    public List<Object> getDataIndex3(@RequestParam(name = "areaSelected1") String areaSelected1,
                                      @RequestParam(name = "areaSelected2") String areaSelected2,
                                     @RequestParam(name = "yearSelected") String yearSelected) {

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

        List<String> legends=new ArrayList<>();
        legends.add(areaSelected1);
        legends.add(areaSelected2);

        List<Double> values=new ArrayList<>();
        List<Double> values1=new ArrayList<>();
        List<Map<String,Object>> indicatorValues=new ArrayList<>();

        for(int i=0;i<tableNames.size();i++){
            List<String> columns=indexMapper.columnName(tableNames.get(i));
            for(int j=0;j<columns.size();j++){
                if(yearSelected.equals(columns.get(j))){
                    double value=indexMapper.Query(tableNames.get(i),areaSelected1,yearSelected);
                    values.add(value);

                    double value1=indexMapper.Query(tableNames.get(i),areaSelected2,yearSelected);
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


        List<Object> result=new ArrayList<>();
        result.add(values);
        result.add(values1);
        result.add(indicatorValues);
        result.add(legends);


        return result;
    }

}
