package com.daeyeo.helloDaeyeo.embedded;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Address {
    private String roadName;
    private String regionName;
    private String sido;
    private String sigungu;
    private String zipCode;
}
