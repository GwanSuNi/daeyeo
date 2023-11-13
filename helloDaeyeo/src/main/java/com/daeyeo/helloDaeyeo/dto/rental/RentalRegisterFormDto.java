package com.daeyeo.helloDaeyeo.dto.rental;

import com.daeyeo.helloDaeyeo.dto.PeriodDto.ApplicationPeriodDto;
import com.daeyeo.helloDaeyeo.dto.PeriodDto.UsagePeriodDto;
import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.embedded.ApplicationPeriod;
import com.daeyeo.helloDaeyeo.embedded.UsagePeriod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RentalRegisterFormDto {
    private String scId;
    private String userId;
    @NotEmpty(message = "장소명을 적어주세요")
    private String objectName;
    @Valid
    private Address address;
    private int usageFee;
    @Valid
    private ApplicationPeriodDto applicationPeriodDto;
    @Valid
    private UsagePeriodDto usagePeriodDto;
    private int cancellation;
    private int maxPerson;
    private List<MultipartFile> files;
    private String webSite;
    @NotEmpty(message = "핸드폰 번호를 입력해주세요")
    private String inquiryPhone;

    public void castLocalDate(RentalRegisterDto rentalRegisterDto) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate applicationPeriodStartDate = LocalDate.parse(this.applicationPeriodDto.getStartDate(), dateFormatter);
        LocalDate applicationPeriodEndDate = LocalDate.parse(this.applicationPeriodDto.getEndDate(), dateFormatter);
        LocalDate usagePeriodStartDate = LocalDate.parse(this.usagePeriodDto.getStartDate(), dateFormatter);
        LocalDate usagePeriodEndDate = LocalDate.parse(this.usagePeriodDto.getEndDate(), dateFormatter);
        LocalTime usagePeriodStartTime = LocalTime.parse(this.usagePeriodDto.getStartTime(), timeFormatter);
        LocalTime usagePeriodEndTime = LocalTime.parse(this.usagePeriodDto.getEndTime(), timeFormatter);

        // Embedde 설정 타입이라 객체를 만들어서 넣어줘야하기때문에 그냥 값을 startDate , endDate 주입시 null 이 뜸 내 예측임
        // 그냥 값을 startDate , endDate 주입시 null 이 뜸 ->팩트

        ApplicationPeriod applicationPeriodRegister = new ApplicationPeriod(applicationPeriodStartDate, applicationPeriodEndDate);
        rentalRegisterDto.setApplicationPeriod(applicationPeriodRegister);
        UsagePeriod usagePeriodRegister = new UsagePeriod(usagePeriodStartDate, usagePeriodEndDate, usagePeriodStartTime, usagePeriodEndTime);
        rentalRegisterDto.setUsagePeriod(usagePeriodRegister);
    }
}

