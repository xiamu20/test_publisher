package com.xiamu.publisher.controller;

import com.xiamu.publisher.service.MySqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSON;
@RestController
public class DataVController {
@Autowired
    MySqlService mySqlService;
@GetMapping("test_sum")
    public String TestSum(@RequestParam("start_dt") String startDt,@RequestParam("end_dt") String endDt){
    if(startDt.length()==0|| endDt.length()==0){
        return "error param is null";
    }
    startDt=startDt.replace("-","");
    endDt=endDt.replace("-","");

    List<Map> testSum = mySqlService.getTestSum(startDt, endDt);
    return JSON.toJSONString(testSum);

}
}
