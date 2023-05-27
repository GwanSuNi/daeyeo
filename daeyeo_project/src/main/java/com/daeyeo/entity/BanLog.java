package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.time.LocalDate;
@Embeddable
@Data
@Table(name="Ban_Log")
public class BanLog {
    private boolean flag;
    private String reason;
    private LocalDate duration;
    private LocalDate date;
}
