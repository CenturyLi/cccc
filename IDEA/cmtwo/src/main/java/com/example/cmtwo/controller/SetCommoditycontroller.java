package com.example.cmtwo.controller;

import com.example.cmtwo.service.SetCommodityservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者 CenturyLi
 * @时间 2019-09-11 20:05
 */
@Controller
public class SetCommoditycontroller {
    @Autowired
    private SetCommodityservice setCommodityservice;

    @ResponseBody
    @RequestMapping(value = "/setcom", method = RequestMethod.POST)
    private Map<String, String> setcom(@RequestParam("Uid") String Uid,@RequestParam("Cname") String Cname,
                           @RequestParam("Price") Float Price, @RequestParam("Originalprice") Float Originalprice,
                           @RequestParam("Intor") String Intor, @RequestParam("Classification") String Classification)
    {
//        System.out.println(Cname+"  "+Intor);
        Map<String, String> map = new HashMap<String, String>();

//        System.out.println(Uid);    //测试取出用户的Uid是否正确
        Integer Cid = 0;
        if (Uid != null)
        {
            Integer Uid1 = Integer.valueOf(Uid);
            Cid = setCommodityservice.insertcom(Uid1, Cname, Price, Originalprice, Intor, Classification);
        }
        map.put("Cid", Cid.toString());
//        System.out.println("最终"+Cid);
//        System.out.println(b);  //测试最终输出的结果是false还是true
        return map;
    }
}
