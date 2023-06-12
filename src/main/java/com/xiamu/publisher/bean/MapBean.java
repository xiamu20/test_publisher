package com.xiamu.publisher.bean;

import java.util.HashMap;

public class MapBean
{
    private HashMap<String,Integer> mapBean;

    @Override
    public String toString() {
        return "MapBean{" +
                "mapBean=" + mapBean +
                '}';
    }

    public MapBean(HashMap<String, Integer> mapBean) {
        this.mapBean = mapBean;
    }

    public HashMap<String, Integer> getMapBean() {

        return mapBean;
    }

    public void setMapBean(HashMap<String, Integer> mapBean) {
        this.mapBean = mapBean;
    }
}
