package com.daeyeo.helloDaeyeo.dto.myPageDto;

import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModalStatusPendingDto {
    String objectName;
    String userName;
    String rentalDate;
    String startTime;
    String endTime;
    String status;

    public ModalStatusPendingDto(RentalStatus rentalStatus) {
        this.objectName = rentalStatus.getRentalObject().getObjectName();
        this.userName = rentalStatus.getMember().getNickname();
        this.rentalDate = rentalStatus.getRentalDate().toString();
        this.startTime = rentalStatus.getStartTime().toString();
        this.endTime = rentalStatus.getEndTime().toString();
        this.status = rentalStatus.getStatus().getLabel();
    }
}
