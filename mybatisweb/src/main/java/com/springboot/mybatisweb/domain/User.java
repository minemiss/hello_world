package com.springboot.mybatisweb.domain;

import org.apache.ibatis.type.Alias;

@Alias(value = "user")
public class User {

    private Long id = null;
    private String user_name = null;
    private String note = null;
    private SexEnum sex = null;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
