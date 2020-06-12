package com.silence.statisticalyearbook.mapper;

import com.silence.statisticalyearbook.dao.TableAll;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManageMapper {

    @Select("SELECT * FROM ${tableName}")
    List<TableAll> queryAll(String tableName);

    @Insert("INSERT INTO ${tableName}(year, beijing, tianjing, hebei, shanxi, neimeng, liaoning, jilin, heilongjiang, shanghai, jiangsu, zhejiang, anhui, fujian, jiangxi, shandong, henan, hubei, hunan, guangdong, guangxi, hainan, chongqin, sichuan, guizhou, yunnan, xizang, shaanxi, gansu, qinhai, ningxia, xinjiang) VALUES (#{tableAll.year}, #{tableAll.beijing}, #{tableAll.tianjing}, #{tableAll.hebei}, #{tableAll.shanxi}, #{tableAll.neimeng}, #{tableAll.liaoning}, #{tableAll.jilin}, #{tableAll.heilongjiang}, #{tableAll.shanghai}, #{tableAll.jiangsu}, #{tableAll.zhejiang}, #{tableAll.anhui}, #{tableAll.fujian}, #{tableAll.jiangxi}, #{tableAll.shandong}, #{tableAll.henan}, #{tableAll.hubei}, #{tableAll.hunan}, #{tableAll.guangdong}, #{tableAll.guangxi}, #{tableAll.hainan}, #{tableAll.chongqin}, #{tableAll.sichuan}, #{tableAll.guizhou}, #{tableAll.yunnan}, #{tableAll.xizang}, #{tableAll.shaanxi}, #{tableAll.gansu}, #{tableAll.qinhai}, #{tableAll.ningxia}, #{tableAll.xinjiang})")
    void addRow(TableAll tableAll,String tableName);

    @Select("SELECT COUNT(*) FROM ${tableName} WHERE year = #{year}")
    Integer hasData(String year,String tableName);

    @Update("UPDATE ${tableName} SET beijing=#{tableAll.beijing}, tianjing=#{tableAll.tianjing}, hebei=#{tableAll.hebei}, shanxi=#{tableAll.shanxi}, neimeng=#{tableAll.neimeng}, liaoning=#{tableAll.liaoning}, jilin=#{tableAll.jilin}, heilongjiang=#{tableAll.heilongjiang}, shanghai=#{tableAll.shanghai}, jiangsu=#{tableAll.jiangsu}, zhejiang=#{tableAll.zhejiang}, anhui=#{tableAll.anhui}, fujian=#{tableAll.fujian}, jiangxi=#{tableAll.jiangxi}, shandong=#{tableAll.shandong}, henan=#{tableAll.henan}, hubei=#{tableAll.hubei}, hunan=#{tableAll.hunan}, guangdong=#{tableAll.guangdong}, guangxi=#{tableAll.guangxi}, hainan=#{tableAll.hainan}, chongqin=#{tableAll.chongqin}, sichuan=#{tableAll.sichuan}, guizhou=#{tableAll.guizhou}, yunnan=#{tableAll.yunnan}, xizang=#{tableAll.xizang}, shaanxi=#{tableAll.shaanxi}, gansu=#{tableAll.gansu}, qinhai=#{tableAll.qinhai}, ningxia=#{tableAll.ningxia}, xinjiang=#{tableAll.xinjiang} WHERE year = #{tableAll.year}")
    void updateRow(TableAll tableAll,String tableName);

    @Delete("DELETE FROM ${tableName} WHERE year = #{year}")
    void delete(String year,String tableName);
}
