package com.daeyeo.helloDaeyeo.dto.PeriodDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationPeriodDto {
    @NotEmpty(message = "날짜를 선택해주세요")
    private String startDate;
    @NotEmpty(message = "날짜를 선택해주세요")
    private String endDate;
}
