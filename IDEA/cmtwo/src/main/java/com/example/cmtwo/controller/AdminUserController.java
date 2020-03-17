package com.example.cmtwo.controller;

import com.example.cmtwo.bean.Userinformation;
import com.example.cmtwo.service.AdminUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class AdminUserController {
    @Autowired
    AdminUserservice adminUserservice;
    Userinformation userinformation;
}
