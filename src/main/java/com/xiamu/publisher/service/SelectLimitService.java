package com.xiamu.publisher.service;

import com.xiamu.publisher.bean.MapBean;
import com.xiamu.publisher.bean.OrderInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SelectLimitService {
    public List<OrderInfo> getSelectLimit(HashMap mapBean);
}
