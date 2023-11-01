package com.daeyeo.helloDaeyeo.entity;

import com.daeyeo.helloDaeyeo.embedded.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rentalLogIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    RentalStatus rentalStatus;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private Address address;
}
