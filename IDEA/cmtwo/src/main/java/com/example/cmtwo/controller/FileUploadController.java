package com.example.cmtwo.controller;

import com.example.cmtwo.service.UpdataImgUrlservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @作者 CenturyLi
 * @时间 2019-09-29 16:30
 */
@RestController
public class FileUploadController
{
    @Autowired
    UpdataImgUrlservice updataImgUrlservice;

    @PostMapping("/upload")
    public boolean upload(@RequestParam("file") MultipartFile uploadFile, HttpServletRequest request)
    {
        String Cid=request.getParameter("Cid");//取出form-data中Cid的值
        String SP=request.getParameter("SP");//取出form-data中Cid的值
        String c = System.getProperty("user.dir");      //获取当前电脑的项目文件夹路径
        String realPath1 = c + "/src/main/resources/static/img/commodity_img";  //将文件存到项目的此路径下
        String realPath2 = c + "/src/main/resources/static/img/user_img";

        try {
            File folder;
            if (SP.equals("c"))
            {
                folder = new File(realPath1);
                if (!folder.isDirectory())
                {
                    folder.mkdirs();
                }
                String oldName = uploadFile.getOriginalFilename();      //获取原文件名
                String suffix = oldName.substring(oldName.lastIndexOf("."));
                String Pname = Cid+suffix;

                uploadFile.transferTo(new File(folder, Pname));
                Integer it = Integer.valueOf(Cid);      //String强转Integer
                updataImgUrlservice.setCommodityImgById(it, Pname);
            }
            else if (SP.equals("h"))
            {
                folder = new File(realPath2);
                if (!folder.isDirectory())
                {
                    folder.mkdirs();
                }
                String oldName = uploadFile.getOriginalFilename();      //获取原文件名
                String suffix = oldName.substring(oldName.lastIndexOf("."));
                String Pname = Cid+suffix;

                uploadFile.transferTo(new File(folder, Pname));
                Integer it = Integer.valueOf(Cid);      //String强转Integer
                updataImgUrlservice.setUserHeadById(it, Pname);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
