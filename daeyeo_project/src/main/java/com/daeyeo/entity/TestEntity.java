package com.daeyeo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="testTable")
public class TestEntity {
    @Id // primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

}
