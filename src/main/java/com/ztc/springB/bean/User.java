package com.ztc.springB.bean;

import java.util.Date;

public class User {
    private String id;
    private String name;
    private String username;
    private Date create_time;
    public User() {
    }
    public User(String id, String name, String username, Date create_time) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.create_time = create_time;
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
