package com.example.cmtwo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @作者 CenturyLi
 * @时间 2019-07-19 19:23
 */

@Mapper
public interface AdminMapper {
    @Select("select * from userinformation ")
    List<userinformation> getadminuserinformation();
}
