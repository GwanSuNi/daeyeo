package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
@Data
public class Address {
    private int zipCode;
    private String roadAddress;
    private String jibunAddress;
    private String sido;
    private String sigungu;
}
