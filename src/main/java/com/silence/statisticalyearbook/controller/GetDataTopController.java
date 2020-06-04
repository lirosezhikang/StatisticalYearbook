package com.silence.statisticalyearbook.controller;

import com.silence.statisticalyearbook.dao.AreaData;
import com.silence.statisticalyearbook.dao.Echarts;
import com.silence.statisticalyearbook.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetDataTopController {

    @Autowired
    AreaMapper areaMapper;

    @GetMapping("/getDataTop")
    @ResponseBody
    public List<Echarts> getData(@RequestParam(name = "dataSelected",defaultValue = "total_value") String dataSelected,
                                 @RequestParam(name = "yearSelected",defaultValue = "y2019") String yearSelected,
                                 Model model){
        List<AreaData> areaDataList= areaMapper.areaQueryTop(dataSelected, yearSelected);
        List<Echarts> echartsList=new ArrayList<>();

        for(int i=0;i<areaDataList.size();i++){
            Echarts echarts=new Echarts();
            echarts.setName(areaDataList.get(i).getAreaName());
            echarts.setValue(areaDataList.get(i).getData());
            echartsList.add(echarts);
        }


        model.addAttribute("areaDataList",areaDataList);
        return echartsList;
    }
}
