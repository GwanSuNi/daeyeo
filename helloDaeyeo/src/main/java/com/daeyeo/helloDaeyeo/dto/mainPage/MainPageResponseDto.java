package com.daeyeo.helloDaeyeo.dto.mainPage;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainPageResponseDto {
    private Map<String, List<String>> categories;
    private Set<MainPageRentalItemDto> recentlyUsedService;
    private Set<MainPageRentalItemDto> myReservationInfo;
}
