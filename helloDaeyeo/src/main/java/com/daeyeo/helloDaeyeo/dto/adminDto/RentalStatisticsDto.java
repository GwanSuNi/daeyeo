package com.daeyeo.helloDaeyeo.dto.adminDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalStatisticsDto {
    private int income;
    private int rentalStatusCount;
    private int successCount;
}
