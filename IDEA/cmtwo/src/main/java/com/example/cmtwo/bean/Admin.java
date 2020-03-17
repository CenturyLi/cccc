package com.example.cmtwo.bean;

/**
 * @作者 CenturyLi
 * @时间 2019-06-22 3:51
 */
public class Admin {
    public Integer getAid() {
        return Aid;
    }

    public void setAid(Integer aid) {
        Aid = aid;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public String getApassword() {
        return Apassword;
    }

    public void setApassword(String apassword) {
        Apassword = apassword;
    }

    private Integer Aid;
    private String Aname;
    private String Apassword;

}
