package com.daeyeo.helloDaeyeo.dto.rental;

import com.daeyeo.helloDaeyeo.embedded.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalObjectDto {
    private Long objectIndex;
    private String mcId;
    private String scId;
    private String userEmail;
    private String objectName;
    private Address address;
    private int usageFee;
    private ApplicationPeriod applicationPeriod;
    private UsagePeriod usagePeriod;
    private int cancellation;
    private int maxPerson;
    private String webSite;
    private String inquiryPhone;
    private int visitCount;
}
