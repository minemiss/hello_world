package com.springboot.chatpter03_demonewbook.Object;

import javax.persistence.*;

@Entity
@Table(name = "t_user2")
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "user_name")
    private String userName = null;

    private String note = null ;

    @Convert(converter = SexConverter.class)
    private SexEnum sex = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
