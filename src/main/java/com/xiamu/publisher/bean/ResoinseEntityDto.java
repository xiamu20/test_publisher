package com.xiamu.publisher.bean;

public class ResoinseEntityDto {

    private final String PAGE_NUM = "pageNum";
    private final String PAGE_SIZE = "pageSize";
    private final String DT_TIME = "dtTime";
    private Integer pageNum;
    private Integer pageSize;
    private String dtTime;

    public String getPAGE_NUM() {
        return PAGE_NUM;
    }

    public String getPAGE_SIZE() {
        return PAGE_SIZE;
    }

    public String getDT_TIME() {
        return DT_TIME;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getDtTime() {
        return dtTime;
    }

    public void setDtTime(String dtTime) {
        this.dtTime = dtTime;
    }
}
