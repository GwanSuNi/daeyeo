package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental_log")
public class RentalLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalLogIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    RentalStatus rentalStatus;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String address;
    private LocalDateTime timeStamp;

    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
        rentalStatus.getRentalLogs().add(this);
    }

}
