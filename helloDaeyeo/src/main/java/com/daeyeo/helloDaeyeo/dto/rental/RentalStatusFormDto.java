package com.daeyeo.helloDaeyeo.dto.rental;

import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "달력을 클릭해 날짜를 입력해주세요")
    private String rentalDate;
    @NotEmpty(message = "시간을 입력해 주세요")
    private String startTime;
    @NotEmpty(message = "시간을 입력해 주세요")
    private String endTime;

    public LocalDateTime castTime(String selectedDate, String time) {
        String combinedStart = selectedDate + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(combinedStart, formatter);
        return startTime;
    }

}
