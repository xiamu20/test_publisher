package com.xiamu.publisher.mapper;

import org.apache.ibatis.annotations.Param;

public interface UpdateSwitchMapper {
    public void  updateStatus(@Param("enabled") String enabled);
}
