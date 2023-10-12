package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.category.MainCategoryDto;
import com.daeyeo.helloDaeyeo.entity.MainCategory;
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
public class MainCategoryMapperImpl implements MainCategoryMapper {

    @Override
    public MainCategoryDto toDto(MainCategory mainCategory) {
        if ( mainCategory == null ) {
            return null;
        }

        MainCategoryDto mainCategoryDto = new MainCategoryDto();

        return mainCategoryDto;
    }

    @Override
    public MainCategory toEntity(MainCategoryDto mainCategoryDto) {
        if ( mainCategoryDto == null ) {
            return null;
        }

        MainCategory mainCategory = new MainCategory();

        mainCategory.setMcId( mainCategoryDto.getMcId() );

        return mainCategory;
    }

    @Override
    public List<MainCategoryDto> toDtoList(List<MainCategory> mainCategories) {
        if ( mainCategories == null ) {
            return null;
        }

        List<MainCategoryDto> list = new ArrayList<MainCategoryDto>( mainCategories.size() );
        for ( MainCategory mainCategory : mainCategories ) {
            list.add( toDto( mainCategory ) );
        }

        return list;
    }
}
