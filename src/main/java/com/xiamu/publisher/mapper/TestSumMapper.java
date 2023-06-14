package com.xiamu.publisher.mapper;

import com.xiamu.publisher.bean.Sum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestSumMapper {
    public List<Sum> Sum(@Param("start_dt") String start_dt , @Param("end_dt") String end_dt);

}
