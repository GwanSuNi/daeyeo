package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="use_info")
public class UseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int infoId;
    private String question;
    private String answer;
}
