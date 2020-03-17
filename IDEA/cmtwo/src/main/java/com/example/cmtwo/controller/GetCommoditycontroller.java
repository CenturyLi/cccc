package com.example.cmtwo.controller;

import com.example.cmtwo.bean.Commodity;
import com.example.cmtwo.bean.Userinformation;
import com.example.cmtwo.service.GetCommodityservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @作者 CenturyLi
 * @时间 2019-07-20 17:46
 */
@Controller
public class GetCommoditycontroller {
    @Autowired
    GetCommodityservice getCommodityservice;

    Commodity commodity;

    @ResponseBody
    @RequestMapping(value = "/only/look",method = RequestMethod.GET)
    public Map<String, String> getcommodityByid(@RequestParam(value = "id") String id)
    {
        Commodity com = new Commodity();
        Userinformation uif = new Userinformation();
        Map<String, String> map = new HashMap<String, String>();
        if(id!=null){
            Integer i = Integer.valueOf(id);
            com = getCommodityservice.getCommodityById(i);
            uif = getCommodityservice.getUserinformationById(i);
            map.put("Cid", com.getCid().toString());
            map.put("Cname", com.getCname());
            map.put("Price", com.getPrice().toString());
            map.put("Originalprice", com.getOriginalprice().toString());
            String data = new SimpleDateFormat("yyyy-MM-dd").format(com.getPublicdata());
            map.put("Publicdata", data);
            map.put("Image", com.getImage());
            map.put("Intor", com.getIntro());
            map.put("Name", uif.getName());
            map.put("QQ", uif.getQQ());
            return map;
        }
        else
        {
            map.put("Cid", null);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/commodity/message",method = RequestMethod.GET)
    public Map<Integer, Map> getcommodityByClass(@RequestParam(value = "Class") String Class,
                                                 @RequestParam(value = "Many") String Many) //判断是取主页的5条信息还是更多里的20条
    {
        List<Commodity> com = new LinkedList<Commodity>();
        Map<Integer, Map> list = new HashMap<Integer, Map>();

        com = getCommodityservice.getCommodityByClass(Many,Class);
        Integer item = 0;

        for(Iterator i = com.iterator(); i.hasNext(); ){
            Map<String, String> map = new HashMap<String, String>();
            commodity = (Commodity) i.next();
            map.put("Cid", commodity.getCid().toString());
            String Cname = commodity.getCname();
            if (commodity.getCname().length() > 14)
            {
                Cname = commodity.getCname().substring(0,14);
                Cname+="...";
            }
            map.put("Cname", Cname);
            map.put("Price", commodity.getPrice().toString());
            String data = new SimpleDateFormat("yyyy-MM-dd").format(commodity.getPublicdata());
            map.put("Publicdata", data);
            map.put("Image", commodity.getImage());
            list.put(item, map);
            item++;
        }
        return list;
    }
}
