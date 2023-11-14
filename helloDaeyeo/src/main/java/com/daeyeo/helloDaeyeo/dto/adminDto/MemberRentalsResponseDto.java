package com.daeyeo.helloDaeyeo.dto.adminDto;

import com.daeyeo.helloDaeyeo.entity.Status;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRentalsResponseDto {
    private Long rentalStatusId;
    private Long objectIndex;
    private String objectName;
    private String offerer;
    private Status status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDate rentalDate;
    private int payment;
}
