package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "Rental_Log")
public class RentalLog {
    @Id
    private int rentalId;
    //외래키
    //private int targetObject;
    //외래키
    //@Column(length = 40)
    //private String targetUser;
    private LocalDate startDuration;
    private LocalDate endDuration;
    private int price;
    private LocalDateTime rentalDate;
}
