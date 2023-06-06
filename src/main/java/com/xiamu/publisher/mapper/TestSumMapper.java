package com.xiamu.publisher.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import java.util.List;
import java.util.Map;
@Mapper
public interface TestSumMapper {
    public List<Map> Sum(@Param("start_Date") String startDate , @Param("end_Date") String endDate);

}
