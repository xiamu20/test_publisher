package com.xiamu.publisher.service;

import com.xiamu.publisher.bean.Sum;
import com.xiamu.publisher.mapper.TestSumMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySqlServiceImpl implements MySqlService {
    @Autowired
    TestSumMapper testSumMapper;

    @Override
    public List<Sum> getTestSum(String startDt, String endDt) {
        return testSumMapper.Sum(startDt,endDt);
    }
}
