package com.daeyeo.entity;

import jakarta.annotation.Nullable;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@ToString(exclude = {"userEntity"})
@AllArgsConstructor
@DynamicUpdate
@Table(name="Ban_Log")
public class BanLog {
    public BanLog() {
        flag = false;
        this.banDate = LocalDateTime.now();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banId")
    private int banId;
    @ManyToOne(optional = true)
    @JoinColumn(name = "userEmail")
    private UserEntity userEntity;
    public void addUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    @Column(nullable = true)
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
