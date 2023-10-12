package com.daeyeo.helloDaeyeo.dto.rental;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.embedded.UsagePeriod;
import com.daeyeo.helloDaeyeo.embedded.Phone;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RentalRegisterDto {
    private String scId;
    private String userId;
    private String objectName;
    private String place;
    private Address address;
    private int usageFee;
    private UsagePeriod usagePeriod;
    private UsagePeriod cancellationUsagePeriod;
    private int maxPerson;
    private String webSite;
    private Phone inquiryPhone;
}
