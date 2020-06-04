package com.silence.statisticalyearbook.mapper;

import com.silence.statisticalyearbook.dao.AreaData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AreaMapper {

    @Select("select area,${yearSelected} as year from ${dataSelected}")
    @Results({
            @Result(property = "areaName",column = "area"),
            @Result(property = "data",column = "year")
    })
    List<AreaData> areaQuery(@Param("dataSelected") String dataSelected, @Param("yearSelected") String yearSelected);

    @Select("select area,${yearSelected} as year from ${dataSelected} where ${yearSelected}=(select MAX(${yearSelected}) from ${dataSelected})")
    @Results({
            @Result(property = "areaName",column = "area"),
            @Result(property = "data",column = "year")
    })
    AreaData maxQuery(@Param("dataSelected") String dataSelected, @Param("yearSelected") String yearSelected);

    @Select("select area,${yearSelected} as year from ${dataSelected} where ${yearSelected}=(select MIN(${yearSelected}) from ${dataSelected})")
    @Results({
            @Result(property = "areaName",column = "area"),
            @Result(property = "data",column = "year")
    })
    AreaData minQuery(@Param("dataSelected") String dataSelected, @Param("yearSelected") String yearSelected);

    @Select("select area,${yearSelected} as year from ${dataSelected} order by ${yearSelected} desc limit 10")
    @Results({
            @Result(property = "areaName",column = "area"),
            @Result(property = "data",column = "year")
    })
    List<AreaData> areaQueryTop(String dataSelected, String yearSelected);
}
