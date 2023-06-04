package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    private int zipCode;
    private String roadAddress;
    private String jibunAddress;
    private String sido;
    private String sigungu;

    public Address(int zipCode) {
        this.zipCode = zipCode;
    }
}
