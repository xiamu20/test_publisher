package com.xiamu.publisher.controller;

import com.xiamu.publisher.bean.Sum;
import com.xiamu.publisher.service.MySqlService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import com.alibaba.fastjson.JSON;
@RestController
public class DataVController {
@Autowired
    MySqlService mySqlService;
//http://localhost:8080/test_sum?start_dt=2022-01-01&end_dt=2022-01-03
@GetMapping("test_sum")
    public String  TestSum( String start_dt, String end_dt){
  //  if(start_dt.length()==0|| end_dt.length()==0){
  //      return "error param is null";
 //   }
   // start_dt=start_dt.replace("-","");
  //  end_dt=end_dt.replace("-","");

    List<Sum> testSum = mySqlService.getTestSum(start_dt, end_dt);
    System.out.println(JSON.toJSON(testSum));

    return JSON.toJSONString(testSum);

}
}
