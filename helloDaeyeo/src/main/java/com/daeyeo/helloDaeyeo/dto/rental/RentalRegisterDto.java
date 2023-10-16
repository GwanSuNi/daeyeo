package com.daeyeo.helloDaeyeo.dto.rental;

import com.daeyeo.helloDaeyeo.embedded.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalRegisterDto {
    private String scId;
    private String userId;
    private String objectName;
    private Address address;
    private int usageFee;
    private ApplicationPeriod applicationPeriod;
    private UsagePeriod usagePeriod;
    private CancellationPeriod cancellationUsagePeriod;
    private int maxPerson;
    private String webSite;
    private Phone inquiryPhone;

    public RentalRegisterDto(String scId , String userEmail , String objectName , Address address){
        this.scId = scId;
        this.userId = userEmail;
        this.objectName = objectName;
        this.address = address;
    }
}
