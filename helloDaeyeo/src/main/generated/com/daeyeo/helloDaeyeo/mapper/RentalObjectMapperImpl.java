package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.RentalObjectDto;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-09T18:18:50+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Azul Systems, Inc.)"
)
@Component
public class RentalObjectMapperImpl implements RentalObjectMapper {

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Override
    public RentalObjectDto toDto(RentalObject rentalObject) {
        if ( rentalObject == null ) {
            return null;
        }

        RentalObjectDto rentalObjectDto = new RentalObjectDto();

        return rentalObjectDto;
    }

    @Override
    public RentalObject toEntity(RentalObjectDto rentalObjectDto) {
        if ( rentalObjectDto == null ) {
            return null;
        }

        RentalObject rentalObject = new RentalObject();

        rentalObject.setSubCategory( subCategoryMapper.toEntity( rentalObjectDto.getSubCategory() ) );

        return rentalObject;
    }

    @Override
    public List<RentalObjectDto> toDtoList(List<RentalObject> rentalObjects) {
        if ( rentalObjects == null ) {
            return null;
        }

        List<RentalObjectDto> list = new ArrayList<RentalObjectDto>( rentalObjects.size() );
        for ( RentalObject rentalObject : rentalObjects ) {
            list.add( toDto( rentalObject ) );
        }

        return list;
    }
}
