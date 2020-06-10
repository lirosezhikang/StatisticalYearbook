package com.silence.statisticalyearbook.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("SELECT password FROM public.\"user\" where name='${username}'")
    String queryPassword(String username);
}
