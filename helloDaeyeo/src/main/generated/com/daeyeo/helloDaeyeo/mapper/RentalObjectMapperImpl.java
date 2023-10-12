package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.SubCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-12T20:04:55+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Azul Systems, Inc.)"
)
@Component
public class RentalObjectMapperImpl implements RentalObjectMapper {

    @Override
    public RentalObjectDto toDto(RentalObject rentalObject) {
        if ( rentalObject == null ) {
            return null;
        }

        RentalObjectDto rentalObjectDto = new RentalObjectDto();

        return rentalObjectDto;
    }

    @Override
    public RentalObject toEntity(RentalRegisterDto rentalRegisterDto, SubCategory subCategory, Member member) {
        if ( rentalRegisterDto == null ) {
            return null;
        }

        RentalObject rentalObject = new RentalObject();

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
