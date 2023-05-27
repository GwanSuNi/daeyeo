package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Admin {
    @Id
    @Column(length = 40)
    private String adminEmail;
    @Column(length = 40)
    private String adminPw;
}
