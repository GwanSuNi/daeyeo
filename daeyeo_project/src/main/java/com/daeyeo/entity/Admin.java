package com.daeyeo.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Immutable
public class Admin {
    @Id
    @Column(length = 40)
    private String adminEmail;
    @Column(length = 40)
    private String adminPw;
}
