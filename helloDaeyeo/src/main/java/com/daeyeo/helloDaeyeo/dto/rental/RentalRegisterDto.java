package com.daeyeo.helloDaeyeo.dto.rental;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.embedded.ApplicationPeriod;
import com.daeyeo.helloDaeyeo.embedded.UsagePeriod;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    private int cancellation;
    private int maxPerson;
    private String webSite;
    private List<MultipartFile> files;
    private String inquiryPhone;
    private int visitCount;

    public RentalRegisterDto(String scId, String userEmail, String objectName, Address address) {
        this.scId = scId;
        this.userId = userEmail;
        this.objectName = objectName;
        this.address = address;
    }

    /***
     * ApplicationPeriod 를 형변환 해서 받아야 되기 때문에 RentalRegisterFormDto 에서 받고 형변환 후에 값들을 여기로 옮겨서
     * 엔티티화 해줌
     * @param rentalRegisterFormDto
     */
    public RentalRegisterDto(RentalRegisterFormDto rentalRegisterFormDto) {
        this.scId = rentalRegisterFormDto.getScId();
        this.userId = rentalRegisterFormDto.getUserId();
        this.objectName = rentalRegisterFormDto.getObjectName();
        this.address = rentalRegisterFormDto.getAddress();
        this.cancellation = rentalRegisterFormDto.getCancellation();
        this.usageFee = rentalRegisterFormDto.getUsageFee();
        this.maxPerson = rentalRegisterFormDto.getMaxPerson();
        this.webSite = rentalRegisterFormDto.getWebSite();
        this.inquiryPhone = rentalRegisterFormDto.getInquiryPhone();
    }

}
