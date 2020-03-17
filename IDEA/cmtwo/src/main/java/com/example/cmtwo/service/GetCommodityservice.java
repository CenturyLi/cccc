package com.example.cmtwo.service;

import com.example.cmtwo.bean.Commodity;
import com.example.cmtwo.bean.Userinformation;
import com.example.cmtwo.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @作者 CenturyLi
 * @时间 2019-07-20 17:36
 */
@Service
public class GetCommodityservice {
    @Autowired
    private CommodityMapper commodityMapper;

    public List<Commodity> getCommodityByClass(String Many, String Class)
    {
        List<Commodity> com = new LinkedList<Commodity>();
        try {
            if (Many.equals("more"))
            {
                if (Class.equals("xx"))
                {
                    com  = commodityMapper.getMoreComByxx();    //调用新鲜
                }
                else
                {
                    com  = commodityMapper.getMoreComByClass(Class);  //调用mapper层查询数据库
                }
            }

            if (Many.equals("less"))
            {
                if (Class.equals("xx"))
                {
                    com  = commodityMapper.getComByxx();    //调用新鲜
                }
                else
                {
                    com  = commodityMapper.getComByClass(Class);  //调用mapper层查询数据库
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return com;
        }
        return com;
    }

    public Commodity getCommodityById(Integer id)
    {
        Commodity com = new Commodity();
        try {
            com  = commodityMapper.getComById(id);    //调用新鲜
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return com;
        }
        return com;
    }

    public Userinformation getUserinformationById(Integer id)
    {
        Userinformation com = new Userinformation();
        try {
            com  = commodityMapper.getUserinfById(id);    //利用商品的id查出卖家信息
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return com;
        }
        return com;
    }
}
