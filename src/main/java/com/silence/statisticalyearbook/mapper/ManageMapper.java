package com.silence.statisticalyearbook.mapper;

import com.silence.statisticalyearbook.dao.TableAll;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ManageMapper {

    @Select("SELECT * FROM ${tableName}")
    List<TableAll> queryAll(String tableName);

    @Insert("INSERT INTO ${tableName}(\n" +
            "\tyear, beijing, tianjing, hebei, shanxi, neimeng, liaoning, jilin, heilongjiang, shanghai, jiangsu, zhejiang, anhui, fujian, jiangxi, shandong, henan, hubei, hunan, guangdong, guangxi, hainan, chongqin, sichuan, guizhou, yunnan, xizang, shaanxi, gansu, qinhai, ningxia, xinjiang)\n" +
            "\tVALUES (#{year}, #{beijing}, #{tianjing}, #{hebei}, #{shanxi}, #{neimeng}, #{liaoning}, #{jilin}, #{heilongjiang}, #{shanghai}, #{jiangsu}, #{zhejiang}, #{anhui}, #{fujian}, #{jiangxi}, #{shandong}, #{henan}, #{hubei}, #{hunan}, #{guangdong}, #{guangxi}, #{hainan}, #{chongqin}, #{sichuan}, #{guizhou}, #{yunnan}, #{xizang}, #{shaanxi}, #{gansu}, #{qinhai}, #{ningxia}, #{xinjiang})")
    void addRow(TableAll tableAll,String tableName);
}
