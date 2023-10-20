package com.daeyeo.helloDaeyeo.dto.PeriodDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsagePeriodDto {
    @NotEmpty(message = "날짜를 입력해주세요")
    private String startDate;
    @NotEmpty(message = "날짜를 입력해주세요")
    private String endDate;
    @NotEmpty(message = "날짜를 입력해주세요")
    private String startTime;
    @NotEmpty(message = "날짜를 입력해주세요")
    private String endTime;

}
