package com.daeyeo.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@ToString(exclude = {"userEntity"})
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Table(name="Ban_Log")
public class BanLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banId")
    private int banId;
    @ManyToOne
    @JoinColumn(name = "userEmail")
    private UserEntity userEntity;
    private boolean flag;
    private String banReason;
    private LocalDateTime duration;
    private LocalDateTime banDate;

    public void switchBanFlag(boolean flag) { this.setFlag(flag);}

    /**
     *
     * @param flag
     * @param banReason
     * @param duration
     */
    public BanLog(boolean flag, String banReason, LocalDateTime duration) {
        this.flag = flag;
        this.banReason = banReason;
        this.duration = duration;
        this.banDate = LocalDateTime.now();
    }
}
