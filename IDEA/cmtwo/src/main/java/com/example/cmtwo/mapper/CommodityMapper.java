package com.example.cmtwo.mapper;


import com.example.cmtwo.bean.Commodity;
import com.example.cmtwo.bean.Userinformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @作者 CenturyLi
 * @时间 2019-07-19 19:23
 */

@Mapper
public interface CommodityMapper {
    //通过商品类别取数据
    public List<Commodity> getComByClass(String Class) throws Exception;
    //若类别为新鲜，则取最后添加的五个
    public List<Commodity> getComByxx() throws Exception;
    //通过商品类别取数据 在更多一栏中一次提取20篇数据
    public List<Commodity> getMoreComByClass(String Class) throws Exception;
    //若类别为新鲜，在更多一栏中，取最后添加的20个商品信息
    public List<Commodity> getMoreComByxx() throws Exception;
    //通过商品编号提取商品数据
    public Commodity getComById(Integer id) throws Exception;
    //通过商品编号提取卖家数据
    public Userinformation getUserinfById(Integer id) throws Exception;
//    <!--通过商家编号提取商家数据-->
    public Userinformation getUserinfByUId(Integer Uid) throws Exception;

    //添加商品
    //@Param("")可以让服务器查找到该项信息
    public int insertCom(Commodity commodity)throws Exception;
    //将图片名存进去
    public int updataComPname(@Param("Cid") Integer Cid,@Param("Image") String Image)throws Exception;
}
