package com.daeyeo.helloDaeyeo.dto.rental;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchSpecDto {
    private String mainCategory;
    private String subCategory;
    private String sido;
    private String sigungu;
    private String searchWord;
}
