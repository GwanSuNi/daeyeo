package com.daeyeo.helloDaeyeo.embedded;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Address {
    @NotEmpty(message = "주소를 입력해주세요")
    private String address;
    private String postcode;
    private String extraAddress;
    @NotEmpty(message = "상세주소를 입력해주세요")
    private String detailAddress;
    private String sido;
    private String sigungu;

    public Address(String address) {
        this.address = address;
    }
}
