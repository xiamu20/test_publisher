package com.xiamu.publisher.service;

import com.xiamu.publisher.bean.Sum;

import java.util.List;

public interface MySqlService {
public List<Sum> getTestSum(String startDt, String endDt);
}
