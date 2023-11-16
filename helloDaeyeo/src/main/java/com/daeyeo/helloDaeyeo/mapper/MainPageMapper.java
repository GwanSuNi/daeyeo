package com.daeyeo.helloDaeyeo.mapper;

import com.daeyeo.helloDaeyeo.dto.mainPage.MainPageRentalItemDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MainPageMapper {
    MainPageRentalItemDto toMainPageRentalItemDto(RentalObjectDto rentalObjectDto);
}
