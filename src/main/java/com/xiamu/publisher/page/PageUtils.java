package com.xiamu.publisher.page;

import com.github.pagehelper.PageInfo;
import com.xiamu.publisher.bean.PageResult;

public class PageUtils {
    //将分页信息封装到统一的接口
    public static PageResult getPageResult(PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
