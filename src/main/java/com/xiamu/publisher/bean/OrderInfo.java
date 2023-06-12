package com.xiamu.publisher.bean;

public class OrderInfo {
    public OrderInfo(int uid, int oid, int dt) {
        this.uid = uid;
        this.oid = oid;
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "uid=" + uid +
                ", oid=" + oid +
                ", dt=" + dt +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    private int uid;
    private int oid;
    private  int dt;
}
