package com.silence.statisticalyearbook.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YearMapper {

    @Select("select year from ${tableName}")
    List<String > queryYear(String tableName);

    @Select("select ${area} from ${tableName}")
    List<Double> queryData(String tableName, String area);
}
