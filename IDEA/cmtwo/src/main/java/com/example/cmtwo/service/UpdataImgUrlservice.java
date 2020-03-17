package com.example.cmtwo.service;

import com.example.cmtwo.mapper.CommodityMapper;
import com.example.cmtwo.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @作者 CenturyLi
 * @时间 2019-11-12 17:11
 */
@Service
public class UpdataImgUrlservice
{
    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private RegisterMapper registerMapper;

    public boolean setCommodityImgById(Integer Cid, String Img)
    {
        boolean b = false;
        try {
            commodityMapper.updataComPname(Cid, Img);
            b = true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return b;
        }
        return b;
    }

    public boolean setUserHeadById(Integer Uid, String Head)
    {
        try {
            registerMapper.updataHead(Head, Uid);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
