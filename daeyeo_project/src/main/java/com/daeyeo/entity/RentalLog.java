package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rental_Log")
public class RentalLog {
    @Id
    private int rentalId;
    //외래키
    //private int targetObject;
    //외래키
    //@Column(length = 40)
    //private String targetUser;
    @ManyToOne
    @JoinColumn(name = "targetObject")
    private RentalObject rentalObject;
    @ManyToOne
    @JoinColumn(name = "targetUser")
    private UserEntity userEntity;

    private LocalDate startDuration;
    private LocalDate endDuration;
    private int price;
    private LocalDateTime rentalDate;

    public RentalLog (UserEntity user, RentalObject rentalObject ,
                      LocalDate startDate, LocalDate endDate, int price){
        this.userEntity = user;
        this.rentalObject = rentalObject;
        this.startDuration = startDate;
        this.endDuration = endDate;
        this.price = price;
        this.rentalDate = LocalDateTime.now();
    }
}
