package com.daeyeo.helloDaeyeo.dto.rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalStatusFormDto {
    private String rentalDate;
    private String startTime;
    private String endTime;

    public void RentalRegisterFormDto(RentalStatusDto rentalStatusDto){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        this.rentalDate
        return;
    }

}
