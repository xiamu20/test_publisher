package com.xiamu.publisher.mapper;

import com.xiamu.publisher.bean.ResoinseEntityDto;

import java.util.List;

public interface PageHelperMapper {

    public List<ResoinseEntityDto> selectManySelective();
    //drop table pagehelper;
    //create table pagehelper( pagenum int,  pagesize int, dt varchar(20));
    //insert into pagehelper values(1,1,'20230706');
    //insert into pagehelper select pagenum+1,pagesize+1,dt+1 from pagehelper;
}
