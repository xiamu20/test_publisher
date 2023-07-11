package com.xiamu.publisher.bean;

public class User {
    String id;
    String name;
    String email;
    String createtime;
    String updatetime;
    String status;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", create_time='" + createtime + '\'' +
                ", update_time='" + updatetime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreate_time() {
        return createtime;
    }

    public void setCreate_time(String create_time) {
        this.createtime = create_time;
    }

    public String getUpdate_time() {
        return updatetime;
    }

    public void setUpdate_time(String update_time) {
        this.updatetime = update_time;
    }
}
