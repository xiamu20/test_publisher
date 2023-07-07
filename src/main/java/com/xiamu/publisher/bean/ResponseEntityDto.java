package com.xiamu.publisher.bean;

public class ResponseEntityDto {
    private final String PAGE_NUM = "pageNum" ;
    private final String PAGE_SIZE = "pageSize" ;
    private int pageNum;
    private int pageSize;

    public String getPAGE_NUM() {
        return PAGE_NUM;
    }

    public String getPAGE_SIZE() {
        return PAGE_SIZE;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
