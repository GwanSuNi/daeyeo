package com.daeyeo.helloDaeyeo.embedded;


import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@Getter
@Setter
public class Address {
    private String address;
    private String postcode;
    private String extraAddress;
    private String detailAddress;

}
