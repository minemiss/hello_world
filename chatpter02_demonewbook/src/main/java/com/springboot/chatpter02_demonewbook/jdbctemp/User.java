package com.springboot.chatpter02_demonewbook.jdbctemp;

import com.springboot.chatpter02_demonewbook.jdbctemp.SexEnum;

public class User {
    private Long id = null;
    private String username = null;
    private SexEnum sex = null;
    private String note = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
