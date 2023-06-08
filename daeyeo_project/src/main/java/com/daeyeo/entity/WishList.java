package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "wish_list")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishListIndex;
    @ManyToOne
    @JoinColumn(name = "userEmail")
    UserEntity userEntity;
    private int objectIndex;
    private LocalDateTime wishedDate;


    public WishList(UserEntity userEntity , int objectIndex , LocalDateTime wishedDate)   {
        this.userEntity = userEntity;
        this.objectIndex = objectIndex;
        this.wishedDate = wishedDate;
    }
}
