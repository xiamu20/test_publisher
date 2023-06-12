package com.xiamu.publisher.controller;

import com.xiamu.publisher.bean.ListUser;
import com.xiamu.publisher.service.ListUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//http://localhost:8080/listuser?
@RestController
public class ListUserController {
    @Autowired
    ListUserServer listUserServer;
    @GetMapping("listuser")
    public List<ListUser>  listUser(@RequestParam("list") List<Integer> uids){
        return listUserServer.getListUser(uids);

    }
}

