package com.example.cmtwo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @作者 CenturyLi
 * @时间 2019-07-20 17:23
 */
public class Commodity {
    private Integer Cid;
    private Integer Uid;
    private String Cname;
    private Float Price;
    private Float Originalprice;
    private String Image;
    private String Intro;
    private String Classification;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date Publicdata;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date Offdata;

    public Float getOriginalprice() {
        return Originalprice;
    }

    public void setOriginalprice(Float originalprice) {
        Originalprice = originalprice;
    }

    public Integer getCid() {
        return Cid;
    }

    public void setCid(Integer cid) {
        Cid = cid;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public Date getPublicdata() {
        return Publicdata;
    }

    public void setPublicdata(Date publicdata) {
        Publicdata = publicdata;
    }

    public Date getOffdata() {
        return Offdata;
    }

    public void setOffdata(Date offdata) {
        Offdata = offdata;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String classification) {
        Classification = classification;
    }
}
