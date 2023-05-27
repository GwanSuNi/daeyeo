package com.daeyeo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="testTable")
public class UserEntity {
    @Id // primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

}
