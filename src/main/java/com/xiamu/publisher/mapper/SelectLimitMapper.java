package com.xiamu.publisher.mapper;

import com.xiamu.publisher.bean.MapBean;
import com.xiamu.publisher.bean.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Mapper
public interface SelectLimitMapper {
    List<OrderInfo> selectLimit(HashMap mapBean);
}
