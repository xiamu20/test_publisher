package com.xiamu.publisher.mapper;

import com.xiamu.publisher.bean.SelectSwitch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SelectSwitchMapper {
   public List<SelectSwitch> getStatus() ;
}
