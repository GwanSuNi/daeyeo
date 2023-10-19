package com.daeyeo.helloDaeyeo.dto.rental;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalListPageInfoDto {
    private int total;
    private int page;
}
