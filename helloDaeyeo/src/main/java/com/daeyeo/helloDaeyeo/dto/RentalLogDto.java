package com.daeyeo.helloDaeyeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/***
 * 컬럼값이 많아질것을 대비해서 만든 dto
 */
public class RentalLogDto {
    int rentalPrice;
}
