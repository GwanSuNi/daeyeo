package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.category.SubCategoryDto;
import com.daeyeo.helloDaeyeo.entity.MainCategory;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-12T01:17:37+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Azul Systems, Inc.)"
)
@Component
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Override
    public SubCategoryDto toDto(SubCategory subCategory) {
        if ( subCategory == null ) {
            return null;
        }

        SubCategoryDto subCategoryDto = new SubCategoryDto();

        subCategoryDto.setMcId( subCategoryMainCategoryMcId( subCategory ) );

        return subCategoryDto;
    }

    @Override
    public SubCategory toEntity(SubCategoryDto subCategoryDto) {
        if ( subCategoryDto == null ) {
            return null;
        }

        SubCategory subCategory = new SubCategory();

        subCategory.setMainCategory( new MainCategory(subCategoryDto.getMcId()) );

        return subCategory;
    }

    @Override
    public List<SubCategoryDto> toDtoList(List<SubCategory> subCategories) {
        if ( subCategories == null ) {
            return null;
        }

        List<SubCategoryDto> list = new ArrayList<SubCategoryDto>( subCategories.size() );
        for ( SubCategory subCategory : subCategories ) {
            list.add( toDto( subCategory ) );
        }

        return list;
    }

    private String subCategoryMainCategoryMcId(SubCategory subCategory) {
        if ( subCategory == null ) {
            return null;
        }
        MainCategory mainCategory = subCategory.getMainCategory();
        if ( mainCategory == null ) {
            return null;
        }
        String mcId = mainCategory.getMcId();
        if ( mcId == null ) {
            return null;
        }
        return mcId;
    }
}
