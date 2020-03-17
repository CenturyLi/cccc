package com.example.cmtwo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.example.cmtwo.mapper")
public class CmtwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmtwoApplication.class, args);
        System.getProperty("user.dir");
    }

}
