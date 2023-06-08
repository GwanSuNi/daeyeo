package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewIndex;
    //외래키
    @ManyToOne
    @JoinColumn(name = "objectIndex")
    RentalObject rentalObject;
    @ManyToOne
    @JoinColumn(name = "writer")
    UserEntity userEntity;
    private LocalDateTime writeDate;
    @Column(length = 100)
    private String content;
    public Review(UserEntity user , RentalObject rentalObject , String content){
        this.userEntity = user;
        this.rentalObject = rentalObject;
        this.content = content;
        this.writeDate = LocalDateTime.now();
    }
}
