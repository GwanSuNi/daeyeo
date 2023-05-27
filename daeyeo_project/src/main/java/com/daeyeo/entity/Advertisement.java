package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.time.LocalDate;
@Embeddable
@Data
public class Advertisement {
    @Column(name = "adId")
    private int adId;
    private String adCompany;
    private LocalDate duration;
    private int price;
    private String adLocation;

}
