package com.example.cmtwo.service;

import com.example.cmtwo.bean.Commodity;
import com.example.cmtwo.bean.Userinformation;
import com.example.cmtwo.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

/**
 * @作者 CenturyLi
 * @时间 2019-07-23 21:53
 */
@Service
public class SetCommodityservice
{
    @Autowired
    CommodityMapper commodityMapper;

    //接收上层传来的前端数据，将其传给mapper层
    public Integer insertcom(Integer Uid, String Cname, Float Price, Float Originalprice, String Intro, String Classification)
    {
        Commodity u = new Commodity();

        u.setUid(Uid);
        u.setCname(Cname);
        u.setPrice(Price);
        u.setOriginalprice(Originalprice);
        u.setIntro(Intro);
        u.setClassification(Classification);
//        System.out.println("前"+u.getCid());
        try {
            commodityMapper.insertCom(u);
//            System.out.println("后"+u.getCid());
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
        return u.getCid();
    }
}
