package com.xiamu.publisher.service;

import com.xiamu.publisher.bean.MapBean;
import com.xiamu.publisher.bean.OrderInfo;
import com.xiamu.publisher.mapper.SelectLimitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SelectLimitServiceImpl implements SelectLimitService {
    @Autowired
    SelectLimitMapper selectLimitMapper;
    @Override
    public List<OrderInfo> getSelectLimit(HashMap mapBean) {
        return selectLimitMapper.selectLimit(mapBean);
    }
}
