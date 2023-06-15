package com.xiamu.publisher.bean;

import lombok.Data;

import java.util.List;
@Data
public class StatisticVo {
    // 表格数据项，即日期 + 数量的列表
    private List<UserStatisticPo> list;
    // 网页的标题
    private String htmlTitle;
    // 表格标题
    private String tableTitle;

}
