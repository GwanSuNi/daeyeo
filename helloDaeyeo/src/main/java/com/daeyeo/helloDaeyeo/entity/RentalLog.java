package com.daeyeo.helloDaeyeo.entity;

import com.daeyeo.helloDaeyeo.dto.RentalLogDto;
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

}
