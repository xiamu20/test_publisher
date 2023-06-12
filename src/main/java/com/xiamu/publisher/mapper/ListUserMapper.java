package com.xiamu.publisher.mapper;

import com.xiamu.publisher.bean.ListUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ListUserMapper {
 List<ListUser>   UserList(List<Integer> uids);
}
