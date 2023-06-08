package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "AdLog")
@Data
public class AdLog {
    //외래키
    private int adId;
    private LocalDate adDate;
    private int loadCount;
    private int clickCount;
    private int totalPrice;
}
