package com.daeyeo.helloDaeyeo.dto.rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalStatusFormDto {
    private long objectId;
    private String rentalDate;
    private String startTime;
    private String endTime;

    public LocalDateTime castTime(String selectedDate, String time) {
        String combinedStart = selectedDate + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(combinedStart, formatter);
        return startTime;
    }

}
