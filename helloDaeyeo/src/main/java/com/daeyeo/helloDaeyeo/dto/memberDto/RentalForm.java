package com.daeyeo.helloDaeyeo.dto.memberDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class RentalForm {
    private String selectedDate;
    // 일단 받고나서 형변환 시도 startTime , endTime 형변환
    private String startTime;
    private String endTime;

    public LocalDateTime castTime(String selectedDate , String time){
        String combinedStart = selectedDate + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(combinedStart, formatter);
        return startTime;
    }
}
