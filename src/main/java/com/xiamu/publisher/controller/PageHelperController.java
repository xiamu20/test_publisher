package com.xiamu.publisher.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiamu.publisher.bean.PageResult;
import com.xiamu.publisher.bean.ResoinseEntityDto;
import com.xiamu.publisher.bean.ResponseEntityDto;
import com.xiamu.publisher.mapper.PageHelperMapper;
import com.xiamu.publisher.page.PageUtils;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
//http://localhost:8080/pageHelper/getPageHelper?pageNum=2&pageSize=4

@RestController
@RequestMapping("/pageHelper")
public class PageHelperController {
    @Resource
    PageHelperMapper mapper;
    @PostMapping("/getPageHelper")
    public PageResult pageInfo(ResponseEntityDto param){
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<ResoinseEntityDto> list = mapper.selectManySelective();
        System.out.println(list.toString());
        if (list.size()==0){
            return null;
        }
        //
        PageInfo<ResoinseEntityDto> pageInfo = new PageInfo<>(list);
        PageResult pageResult = PageUtils.getPageResult(pageInfo);

        return pageResult;
    }
}
