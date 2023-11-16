package com.daeyeo.helloDaeyeo.service;

import com.daeyeo.helloDaeyeo.dto.mainPage.MainPageRentalItemDto;
import com.daeyeo.helloDaeyeo.dto.mainPage.MainPageResponseDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalStatusDto;
import com.daeyeo.helloDaeyeo.entity.Status;
import com.daeyeo.helloDaeyeo.mapper.MainPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MainPageService {
    private final SubCategoryService subCategoryService;
    private final RentalObjectService rentalObjectService;
    private final RentalStatusService rentalStatusService;
    private final MainPageMapper mainPageMapper;

    public MainPageResponseDto prepareMainPage(String username) {
        Map<String, List<String>> categories = subCategoryService.getAllCategories();
        List<RentalStatusDto> rentalStatusDtos = rentalStatusService.findRentalStatusesDesc(username);

        Set<MainPageRentalItemDto> recentlyUsedService = getRecentlyUsedService(rentalStatusDtos);
        Set<MainPageRentalItemDto> myReservationInfo = getMyReservationInfo(rentalStatusDtos);

        return new MainPageResponseDto(categories, recentlyUsedService, myReservationInfo);
    }

    private Set<MainPageRentalItemDto> getRecentlyUsedService(List<RentalStatusDto> rentalStatusDtos) {
        Set<MainPageRentalItemDto> recentlyUsedService = new LinkedHashSet<>(10);

        for (RentalStatusDto rentalStatusDto : rentalStatusDtos) {
            RentalObjectDto objectDto = rentalObjectService.getRentalObject(rentalStatusDto.getObjectIndex());
            MainPageRentalItemDto responseDto = mainPageMapper.toMainPageRentalItemDto(objectDto);

            recentlyUsedService.add(responseDto);

            if (recentlyUsedService.size() == 10)
                break;
        }

        return recentlyUsedService;
    }

    private Set<MainPageRentalItemDto> getMyReservationInfo(List<RentalStatusDto> rentalStatusDtos) {
        Set<MainPageRentalItemDto> myReservationInfo = new LinkedHashSet<>(3);

        for (RentalStatusDto rentalStatusDto : rentalStatusDtos) {
            if (rentalStatusDto.getStatus() == Status.PENDING || rentalStatusDto.getStatus() == Status.ACCEPTED) {
                RentalObjectDto objectDto = rentalObjectService.getRentalObject(rentalStatusDto.getObjectIndex());
                MainPageRentalItemDto responseDto = mainPageMapper.toMainPageRentalItemDto(objectDto);

                myReservationInfo.add(responseDto);
            }

            if (myReservationInfo.size() == 3)
                break;
        }

        return myReservationInfo;
    }
}
