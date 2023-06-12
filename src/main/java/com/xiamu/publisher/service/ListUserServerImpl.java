package com.xiamu.publisher.service;

import com.xiamu.publisher.bean.ListUser;
import com.xiamu.publisher.mapper.ListUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListUserServerImpl implements ListUserServer {
    @Autowired
    ListUserMapper listUserMapper;
    @Override
    public List<ListUser> getListUser(List<Integer> uids) {
        return listUserMapper.UserList(uids);
    }
}
