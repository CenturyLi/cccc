package com.example.cmtwo.mapper;

import com.example.cmtwo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @作者 CenturyLi
 * @时间 2019-06-22 3:54
 */

@Mapper
public interface UserMapper {

    @Select("select * from user where Uname = #{Uname}")
    public List<User> getUserByName(String Uname)throws Exception;

    @Delete("delete from user where Uid = #{Uid}")
    public int deleteUserById(Integer id)throws Exception;

    //@Options注解，告诉程序Uid字段为自增模式，无需导入
    @Options(useCache = true,keyColumn = "Uid")
    @Insert("insert into User(Uname, Upassword) value(#{Uname},#{Upassword})")
    public int insertUser(@Param("Uname") String Uname,@Param("Upassword") String Upassword)throws Exception;

    @Update("update User set Uname=#{Uname},Upassword=#{Upassword}")
    public int updateUser(User user)throws Exception;
}
