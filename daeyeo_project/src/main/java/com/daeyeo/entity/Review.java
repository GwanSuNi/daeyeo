package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewIndex;
    //외래키
    private int objectIndex;
    //외래키
    @Column(length = 40)
    private String writer;
    private LocalDateTime writeDate;
    @Column(length = 100)
    private String content;
}
