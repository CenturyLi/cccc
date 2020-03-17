package com.example.cmtwo.mapper;

import com.example.cmtwo.bean.User;
import org.apache.ibatis.annotations.*;

/**
 * @作者 CenturyLi
 * @时间 2019-07-11 21:08
 */
@Mapper
public interface RegisterMapper {

    //注册信息，将前端内容插入数据库
    @Options(useCache = true,keyColumn = "Uid")
    @Insert("insert into userinformation(Name, Son, Head, Sex, QQ) value(#{Name}, #{Son}, #{Head}, #{Sex}, #{QQ})")
    public int insertInf(@Param("Name") String Name,@Param("Son") String Son,@Param("Sex") String Sex,@Param("QQ") String QQ , @Param("Head") String Head)throws Exception;

    @Update("update userinformation set Head = #{Head} where Uid = #{Uid}")
    public void updataHead(@Param("Head") String Head, @Param("Uid") Integer Uid);

    //查询用户昵称是否重复
    @Select("select Son from userinformation where Name = #{Name}")
    public String selectSoByNa(String Name)throws Exception;
}
