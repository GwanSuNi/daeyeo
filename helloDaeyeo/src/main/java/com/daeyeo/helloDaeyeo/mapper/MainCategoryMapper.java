package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.entity.MainCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MainCategoryMapper {
    MainCategoryDto toDto(MainCategory mainCategory);

    MainCategory toEntity(MainCategoryDto mainCategoryDto);

    List<MainCategoryDto> toDtoList(List<MainCategory> mainCategories);
}
