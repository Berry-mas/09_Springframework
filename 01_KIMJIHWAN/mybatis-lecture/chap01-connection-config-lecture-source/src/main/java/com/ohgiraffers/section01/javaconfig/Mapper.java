package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Mapper {
//    @Update()
//    @Delete()
    @Select("SELECT NOW()")
    java.util.Date selectDate();
}
