package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Ban_Log")
public class BanLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int banId;
    private boolean flag;
    private String banReason;
    private LocalDateTime duration;
    private LocalDateTime banDate;

    public void setBanFlagTrue() {
        flag = true;
    }
    public void setBanFlagFalse() {
        flag = false;
    }

    public BanLog(boolean flag, String banReason, LocalDateTime duration) {
        this.flag = flag;
        this.banReason = banReason;
        this.duration = duration;
        this.banDate = LocalDateTime.now();
    }
}
