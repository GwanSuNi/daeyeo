package com.daeyeo.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class DaeyeoUserEntity {
    @Id
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public DaeyeoUserEntity() {
    }

    public DaeyeoUserEntity(String userEmail) {
        this.userEmail = userEmail;
    }
}
