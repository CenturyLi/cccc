package com.example.cmtwo.service;

import com.example.cmtwo.bean.User;
import com.example.cmtwo.bean.Userinformation;
import com.example.cmtwo.mapper.CommodityMapper;
import com.example.cmtwo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @作者 CenturyLi
 * @时间 2019-07-11 16:27
 */
@Service
public class Loginservice
{
    @Autowired
    private UserMapper userMapper;  //在service层调用mapper层接口

    @Autowired
    private CommodityMapper commodityMapper;

    //find方法，接收controller层发送的用户名密码，并调用mapper与数据库交互进行判断
    public String Find(String name, String password)
    {
        List<User> com = new LinkedList<User>();
        User user;

        try {
            com = userMapper.getUserByName(name);  //调用mapper层查询数据库
            Iterator i = com.iterator();
            user = (User) i.next();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return "false";
        }

        if (user != null)    //若查出结果为空，则数据库内无此人信息，登录失败
        {
            if (user.getUpassword().equals(password))
            {
                return user.getUid().toString();
            }
            else
            {
                return "false";
            }
        }
        else
        {
            return "false";
        }
    }

    //通过用户Uid信息查询用户详细信息
    public Userinformation getUserinformationByUId(Integer Uid)
    {
        Userinformation com = new Userinformation();
        try {
            com  = commodityMapper.getUserinfByUId(Uid);    //利用商品的id查出卖家信息
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return com;
        }
        return com;
    }
}
