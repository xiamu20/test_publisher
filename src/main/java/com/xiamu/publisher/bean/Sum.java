package com.xiamu.publisher.bean;

import java.util.Objects;

public class Sum {
    @Override
    public String toString() {
        return "Sum{" +
                "uid2=" + uid2 +
                ", a2=" + a2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sum)) return false;
        Sum sum = (Sum) o;
        return getUid2() == sum.getUid2() &&
                getA2() == sum.getA2();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUid2(), getA2());
    }

    public void setUid2(int uid2) {

        this.uid2 = uid2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public int getUid2() {

        return uid2;
    }

    public int getA2() {
        return a2;
    }

    public Sum(int uid2, int a2) {

        this.uid2 = uid2;
        this.a2 = a2;
    }

    private int uid2;
private int a2;




}
