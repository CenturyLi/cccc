package com.example.cmtwo.service;

import com.example.cmtwo.bean.User;
import com.example.cmtwo.mapper.RegisterMapper;
import com.example.cmtwo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @作者 CenturyLi
 * @时间 2019-07-11 20:52
 */
@Service
public class Registerservice {

    @Autowired
    //生成mapper层对象
    private RegisterMapper registerMapper;

    @Autowired
    private UserMapper userMapper;

    //接收上层传来的前端数据，将其传给mapper层
    public boolean Ins(String Name, String Son, String Sex, String QQ)
    {
        try {
            String Head = "0.jpg";
            registerMapper.insertInf(Name, Son, Sex, QQ, Head);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    //接收上层传来的前端数据，将其传给mapper层
    public boolean Inspass(String Uname, String Upassword)
    {
        try {
            //将对应数据插入数据库
            userMapper.insertUser(Uname, Upassword);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    //查询数据库中学号是否重复
    public boolean Find_son(String Son)
    {
        List<User> com = new LinkedList<User>();

        try {
            com = userMapper.getUserByName(Son);  //调用mapper层查询数据库
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }

        return com.size() == 0;
    }

    //查询数据库中用户昵称是否重复
    public boolean Find_name(String Name)
    {
        String b;

        try {
            //查询数据库中昵称是否重复
            b = registerMapper.selectSoByNa(Name);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return b == null;   //b若是空的，返回true，可以使用，非空返回false，已被注册
    }
}
