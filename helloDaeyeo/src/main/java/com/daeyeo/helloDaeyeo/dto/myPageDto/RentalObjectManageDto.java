package com.daeyeo.helloDaeyeo.dto.myPageDto;

import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.entity.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RentalObjectManageDto {
    private long objectIndex;
    private String objectName;
    private String address;
    private String detailAddress;
    private int statusCount;
    private int statusCompleted;
    private int statusPending;
    private int statusHold;
    private int statusCancel;

    public RentalObjectManageDto(RentalObject rentalobject) {
        this.objectIndex = rentalobject.getObjectIndex();
        this.objectName = rentalobject.getObjectName();
        this.address = rentalobject.getAddress().getAddress();
        this.detailAddress = rentalobject.getAddress().getDetailAddress();
        this.statusCount = rentalobject.getRentalStatuses().size();
        List<RentalStatus> rentalStatusList = rentalobject.getRentalStatuses();
        for (RentalStatus rentalStatus : rentalStatusList) {
            if (rentalStatus.getStatus() == Status.PENDING) {
                this.statusPending++;
            } else if (rentalStatus.getStatus() == Status.COMPLETED
                    || rentalStatus.getStatus() == Status.ACCEPTED) {
                this.statusCompleted++;
            } else if (rentalStatus.getStatus() == Status.HOLD) {
                this.statusHold++;
            } else {
                this.statusCancel++;
            }
        }
    }
}
