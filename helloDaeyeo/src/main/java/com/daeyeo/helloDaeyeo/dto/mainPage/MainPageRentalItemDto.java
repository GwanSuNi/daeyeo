package com.daeyeo.helloDaeyeo.dto.mainPage;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class MainPageRentalItemDto {
    private Long objectIndex;
    private String mcId;
    private String scId;
    private String objectName;
}
