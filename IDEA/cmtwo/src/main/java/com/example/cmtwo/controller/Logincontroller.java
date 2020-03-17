package com.example.cmtwo.controller;

import com.example.cmtwo.bean.Userinformation;
import com.example.cmtwo.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @作者 CenturyLi
 * @时间 2019-07-11 16:29
 */
@Controller
public class Logincontroller
{
    @Autowired
    private Loginservice loginservice;  //生成service层实体类

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    //@RequestParam注解规范的接收发来的内容，若不用定义的参数名要与前端一模一样，注解value值也要与前端一致
    public Map<String, String> login(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "password") String password,
                                     HttpServletRequest request)
    {
        String Uid;
        Map<String, String> map = new HashMap<String, String>();
        Userinformation uif = new Userinformation();

        Uid = loginservice.Find(name, password);     //接收调用service层，将从前端ajax接收到的信息传出去，并得到结果
        if(Uid!=null) {
            Integer i = Integer.valueOf(Uid);
            uif = loginservice.getUserinformationByUId(i);
        }

        if (!Uid.equals("false"))
        {
            HttpSession session = request.getSession();

//            System.out.println(Uid); //测试Uid是否取出
            session.setAttribute("Uid", Uid);
            session.setAttribute("name", name);
            map.put("Uid", Uid);
            map.put("name", name);
            map.put("username", uif.getName());
            map.put("headimg", uif.getHead());
            map.put("result", "yes");

            return map;       //service层判定成功或失败后传回前端，前端的回调函数接收到进行相应处理
        }
        else
        {
            map.put("result", "no");
            return map;
        }
    }
}
