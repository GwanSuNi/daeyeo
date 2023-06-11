package com.daeyeo.command;

import com.daeyeo.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalObjectCmd {
    String mcId;
    String scId;
    String objectName;
    String target;
    int price;
    String location;
    String website;
    String objectImage;
    int zipCode;
    String jibunAddress;
    String roadAddress;
    String sido;
    String sigungu;
    String locationInfo;
    String receiptStartDuration;
    String receiptEndDuration;
    String startDuration;
    String endDuration;
    int capacity;
//    취소기간
//    예약방법
    String representNum;
    String useInfo;
}