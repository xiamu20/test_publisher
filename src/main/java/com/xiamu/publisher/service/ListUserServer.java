package com.xiamu.publisher.service;

import com.xiamu.publisher.bean.ListUser;

import java.util.List;

public interface ListUserServer {
    public List<ListUser> getListUser(List<Integer> uids);
}
