package com.xiamu.publisher.service;

import com.xiamu.publisher.mapper.TestSumMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class MySqlServiceImpl implements MySqlService {
    @Autowired
    TestSumMapper testSumMapper;

    @Override
    public List<Map> getTestSum(String startDt, String endDt) {
        return testSumMapper.Sum(startDt,endDt);
    }
}
