package com.daeyeo.helloDaeyeo.dto.memberDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class RentalForm {
    private LocalDate selectedDate;
    private LocalDateTime localDateTime;

}
