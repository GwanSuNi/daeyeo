package com.daeyeo.helloDaeyeo.dto.rental;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.embedded.CancellationPeriod;
import com.daeyeo.helloDaeyeo.embedded.Phone;
import com.daeyeo.helloDaeyeo.embedded.UsagePeriod;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class RentalObjectDto {
    private Long objectIndex;
    @Setter
    private String scId;
    @Setter
    private String userEmail;
    private String objectName;
    private String place;
    private Address address;
    private int usageFee;
    private UsagePeriod usagePeriod;
    private CancellationPeriod cancellationPeriod;
    private int maxPerson;
    private String webSite;
    private Phone inquiryPhone;
}
