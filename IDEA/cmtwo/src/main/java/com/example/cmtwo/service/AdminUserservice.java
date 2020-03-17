package com.example.cmtwo.service;

import com.example.cmtwo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserservice {
    @Autowired
    private AdminMapper adminMapper;


}
