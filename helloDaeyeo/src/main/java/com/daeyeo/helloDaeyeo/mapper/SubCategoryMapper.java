package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
    @Mapping(source = "mainCategory.mcId", target = "mcId")
    SubCategoryDto toDto(SubCategory subCategory);

    @Mapping(target = "mainCategory", expression = "java(new MainCategory(subCategoryDto.getMcId()))")
    SubCategory toEntity(SubCategoryDto subCategoryDto);

    List<SubCategoryDto> toDtoList(List<SubCategory> subCategories);
}
