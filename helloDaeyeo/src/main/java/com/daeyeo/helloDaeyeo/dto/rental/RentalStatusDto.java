package com.daeyeo.helloDaeyeo.dto.rental;

import com.daeyeo.helloDaeyeo.entity.Status;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalStatusDto {
    private int rentalStatusId;
    private String userEmail;
    private Long objectIndex;
    private Status status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDate rentalDate;

    public RentalStatus(RentalStatusFormDto rentalStatusFormDto) {
        rentalStatusFormDto.getRentalDate();
        rentalStatusFormDto.getStartTime();
        rentalStatusFormDto.getEndTime();
    }
}
