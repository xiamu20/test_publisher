package com.xiamu.publisher.mapper;

import com.xiamu.publisher.bean.UserStatisticPo;

import java.util.List;

public interface UserStatisticMapper {
    /**
     * 统计最近多少天内的新增用户数
     *
     * @param days 统计的天数，从当前这一天开始
     * @return
     */
    List<UserStatisticPo> statisticUserCnt(int dasys);
}
