package com.silence.statisticalyearbook.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IndexMapper {
    @Select("select ${yearSelected} from ${tableName} where area=#{areaSelected}")
    double Query(String tableName,String areaSelected,String yearSelected);

    @Select("select MAX(${yearSelected}) from ${tableName}")
    double maxData(String tableName,String yearSelected);

    @Select("select column_name from information_schema.columns where table_schema='public' and table_name=#{tableName}")
    List<String> columnName(String tableName);
}
