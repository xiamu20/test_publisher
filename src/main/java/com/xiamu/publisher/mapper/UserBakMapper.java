package com.xiamu.publisher.mapper;

import com.xiamu.publisher.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBakMapper{
    List<User> select(@Param("id") String id);
    int delete(@Param("id") String id);
    int insert(User user);
    List<User> getUser(@Param("id") String id);
}
