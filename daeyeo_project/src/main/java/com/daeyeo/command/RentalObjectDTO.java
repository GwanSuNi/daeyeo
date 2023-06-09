package com.daeyeo.command;

import com.daeyeo.entity.Address;
import com.mysql.cj.xdevapi.AddResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalObjectDTO {
    String scId;
    String ownerEmail;
    String objectName;
    int price;
    int wishCount;
    String website;
    String target;
    LocalDateTime createDate;
    int capacity;
    String representNum1;
    String representNum2;
    String representNum3;

    String useInfo;
    String locationInfo;
    String objectImage;
    LocalDate startDuration;
    LocalDate endDuration;
    LocalDate receiptStartDuration;
    LocalDate receiptEndDuration;
    int vistCount;
    Address address ;
}