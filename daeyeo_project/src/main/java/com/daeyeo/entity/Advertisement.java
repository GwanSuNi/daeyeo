package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Embeddable
@Data
@NoArgsConstructor
@Table(name = "Advertisement")
public class Advertisement {
    @Column(name = "adId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adId;
//    private String adOwnerEmail;
    private String adCompany;
    private LocalDate duration;
    private int price;
    private String adImage;
    private String adLocation;

    public Advertisement(String adCompany, LocalDate duration, int price, String adImage, String adLocation) {
        this.adCompany = adCompany;
        this.duration = duration;
        this.price = price;
        this.adImage = adImage;
        this.adLocation = adLocation;
    }

    public Advertisement(int adId) {
        this.adId = adId;
    }
}
