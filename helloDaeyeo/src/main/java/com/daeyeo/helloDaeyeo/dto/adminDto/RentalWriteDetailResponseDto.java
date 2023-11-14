package com.daeyeo.helloDaeyeo.dto.adminDto;

import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalWriteDetailResponseDto {
    private RentalObjectDto rentalObject;
    private RentalStatisticsDto rentalStatistics;
    private List<RentalUsersDetailDto> rentalUsersDetails;
}
