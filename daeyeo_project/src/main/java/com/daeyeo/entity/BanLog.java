package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.time.LocalDate;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Ban_Log")
public class BanLog {
    private boolean flag;
    private String banReason;
    private LocalDate duration;
    private LocalDate banDate;
}
