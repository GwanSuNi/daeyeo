package com.daeyeo.helloDaeyeo.dto.rental;

import com.daeyeo.helloDaeyeo.entity.Status;
import com.daeyeo.helloDaeyeo.exception.NotPermitTime;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalStatusDto {

    private int rentalStatusId;
    private String userEmail;
    private Long objectIndex;
    private Status status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDate rentalDate;

    /***
     * 폼에서 입력받아온 시간값을 검증하고 RentalDto에 넣어줌
     * RentalDto를 Entity 로 변환해서 값을 넣기 전에 검증할것임
     * @param rentalStatusFormDto
     */

    public RentalStatusDto(RentalStatusFormDto rentalStatusFormDto, Boolean isInside) {
        String dataString = rentalStatusFormDto.getRentalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.rentalDate = LocalDate.parse(dataString, formatter); // 형변환 후 값 넣음

        LocalDateTime startTime = rentalStatusFormDto.castTime(dataString, rentalStatusFormDto.getStartTime());
        LocalDateTime endTime = rentalStatusFormDto.castTime(dataString, rentalStatusFormDto.getEndTime());

        // 여기서 형변환 후에 값 검증
        if (startTime.isBefore(endTime) && isInside) { // startTime 이 endTime 보다 이전이냐
            // start = 9 시 end 가 2 시면 끝나는 시간보다 이전이냐? 물어보는뜻
            this.startTime = startTime;
            this.endTime = endTime;
            this.objectIndex = rentalStatusFormDto.getObjectId();
        } else { // 참이 아닐경우
            throw new NotPermitTime("허용되지않는 시간입니다.");
        }
    }
}

