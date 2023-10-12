package com.daeyeo.helloDaeyeo.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class SubCategoryDto {
    private String scId;
    @Setter
    private String mcId;
}
