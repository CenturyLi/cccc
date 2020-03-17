package com.example.cmtwo.bean;

/**
 * @作者 CenturyLi
 * @时间 2019-07-11 20:54
 */
public class Userinformation {
    private Integer Uid;    //用户id，自增
    private String Name;    //用户名，自己定义
    private String Son;     //学号，即后user中的username，登录的用户名
    private String Idphoto;//一卡通图片上传地址
    private String Head;    //头像图片地址
    private String Sex;     //用户性别
    private String QQ;      //用户联系方式
    private String Intro;   //用户自我简介

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSon() {
        return Son;
    }

    public void setSon(String son) {
        Son = son;
    }

    public String getIdphoto() {
        return Idphoto;
    }

    public void setIdphoto(String idphoto) {
        Idphoto = idphoto;
    }

    public String getHead() {
        return Head;
    }

    public void setHead(String head) {
        Head = head;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String intro) {
        Intro = intro;
    }
}
