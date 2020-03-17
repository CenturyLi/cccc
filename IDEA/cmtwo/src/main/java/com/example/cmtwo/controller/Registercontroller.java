package com.example.cmtwo.controller;

import com.example.cmtwo.bean.Userinformation;
import com.example.cmtwo.service.Loginservice;
import com.example.cmtwo.service.Registerservice;
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
 * @时间 2019-07-11 20:50
 */
@Controller
public class Registercontroller {

    @Autowired
    private Registerservice registerservice;

    @Autowired
    private Loginservice loginservice;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, String> regist(@RequestParam(value = "Name") String Name, @RequestParam(value = "Son") String Son,
                                       @RequestParam(value = "QQ") String QQ, @RequestParam(value = "Password") String Password,
                                       HttpServletRequest request)
    {
        String Sex = "保密";  //性别默认为保密，后期可自行修改
        Map<String, String> map = new HashMap<String, String>();
        Userinformation uif = new Userinformation();

        boolean b = registerservice.Ins(Name, Son,  Sex, QQ);
        if (!b)
        {
            map.put("result", "no");
            return map;
        }
        b = registerservice.Inspass(Son, Password);

        if (!b)
        {
            map.put("result", "no");
            return map;
        }

        String Uid = loginservice.Find(Son, Password);     //接收调用service层，将从前端ajax接收到的信息传出去，并得到结果;
        System.out.println(uif.getHead());
        if(Uid!=null) {
            Integer i = Integer.valueOf(Uid);
            uif = loginservice.getUserinformationByUId(i);
        }
        HttpSession session = request.getSession();

        session.setAttribute("Uid", Uid);
        session.setAttribute("name", Son);

        map.put("Uid", Uid);
        map.put("name", Son);
        map.put("username", uif.getName());
        map.put("headimg", uif.getHead());
        map.put("result", "yes");

        return map;
    }

    //判定昵称是否重复
    @RequestMapping(value = "/name/repeat_1", method = RequestMethod.GET)
    @ResponseBody
    private boolean repeat_name(@RequestParam(value = "name") String Name)
    {
        return registerservice.Find_name(Name);
    }

    //判定学号是否重复
    @RequestMapping(value = "/son/repeat_2", method = RequestMethod.GET)
    @ResponseBody
    private boolean repeat_son(@RequestParam(value = "son") String Son)
    {
        return registerservice.Find_son(Son);
    }
}
