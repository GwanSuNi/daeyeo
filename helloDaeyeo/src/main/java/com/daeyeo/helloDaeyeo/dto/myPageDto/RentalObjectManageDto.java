package com.daeyeo.helloDaeyeo.dto.myPageDto;

import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.entity.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class RentalObjectManageDto {
    private String objectName;
    private String address;
    private int statusCount;
    private int statusCompleted;
    private int statusPending;

    public RentalObjectManageDto(RentalObject rentalobject) {
        this.objectName = rentalobject.getObjectName();
        this.address = rentalobject.getAddress().getAddress();
        this.statusCount = rentalobject.getRentalStatuses().size();
        Set<RentalStatus> rentalStatusList = rentalobject.getRentalStatuses();
        for (RentalStatus rentalStatus : rentalStatusList) {
            if (rentalStatus.getStatus() == Status.PENDING) {
                this.statusPending++;
            } else if (rentalStatus.getStatus() == Status.COMPLETED) {
                this.statusCompleted++;
            }
        }
    }
}
