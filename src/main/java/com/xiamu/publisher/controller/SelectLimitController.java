package com.xiamu.publisher.controller;

import com.alibaba.fastjson.JSON;
import com.xiamu.publisher.service.SelectLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//http://localhost:8080/selectlimit?map["startIndex"]=1&map["pageSize"]=1
@RestController
public class SelectLimitController {
    @Autowired
    SelectLimitService selectLimitService;
    @GetMapping("selectlimit")
    public String selectLimit(@RequestParam HashMap mapBean){

           try {
               // 执行可能抛出异常的逻辑操作
               // 如果出现异常，将被捕获并进入 catch 块处理
               mapBean.isEmpty();
           } catch (Exception e) {
               // 在这里处理异常
               return "\"Empty Map received\": " + e.getMessage();
           }
           return (String) JSON.toJSON(selectLimitService.getSelectLimit(mapBean));
    }
}
