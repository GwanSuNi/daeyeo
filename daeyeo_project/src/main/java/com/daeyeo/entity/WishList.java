package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "Wish_List")
public class WishList {

//    @Column(length = 40)
//    //외래키
//    private String userEmail;
//    // 외래키
//    private int objectInex;

    private LocalDateTime wishedDate;
        // 찜목록 아닌가 ? 왜 날짜가..
        // 연관관계 설정에 아마 예측인데 기본키가 없으면
        // 연관할 수 없나보다 ? ? ?
}
