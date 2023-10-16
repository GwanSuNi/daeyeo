package com.daeyeo.helloDaeyeo.dto.rental;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchSpecDto {
    private String mainCategory;
    private String subCategory;
    private String sido;
    private String sigungu;
    private String searchWord;
    private String sort;
}
