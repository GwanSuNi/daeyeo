package com.daeyeo.helloDaeyeo.dto.adminDto;

import com.daeyeo.helloDaeyeo.embedded.Address;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllMembersRentalWritesResponseDto {
    private Long objectIndex;
    private String objectName;
    private String offerer;
    private Address address;
    private int income;
    private int rentalStatusCount;
    private int successCount;
    //    private int reviewCount;
//    private int favoriteCount;
    private int visitCount;
}
