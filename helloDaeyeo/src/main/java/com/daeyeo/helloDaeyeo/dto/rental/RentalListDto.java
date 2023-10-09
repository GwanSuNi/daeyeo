package com.daeyeo.helloDaeyeo.dto.rental;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RentalListDto {
    private String mainCategory;
    private String subCategory;
    private String searchWord;
    private String sort;
    private String type;
    private int total;
    private int page;

    public RentalListDto(String mainCategory, String subCategory, String searchWord, int total) {
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.searchWord = searchWord;
        this.sort = "receipt";
        this.type = "list";
        this.total = total;
        this.page = 1;
    }
}
