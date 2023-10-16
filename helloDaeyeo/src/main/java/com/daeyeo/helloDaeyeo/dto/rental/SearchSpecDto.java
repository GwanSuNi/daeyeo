package com.daeyeo.helloDaeyeo.dto.rental;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchSpecDto {
    private String mainCategory;
    private String subCategory;
    private String sido;
    private String sigungu;
    private String searchWord;
    private String sort;
}
