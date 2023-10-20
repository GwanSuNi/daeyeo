package com.daeyeo.helloDaeyeo.dto.rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalStatusFormDto {
    LocalDate rentalDate;
    LocalTime startTime;
    LocalTime endTime;

}
