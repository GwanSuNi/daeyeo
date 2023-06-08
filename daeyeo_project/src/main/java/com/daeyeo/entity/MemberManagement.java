package com.daeyeo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "membermanagement")
public class MemberManagement {
    @Id
    private String id;
    private String userCategory;
    private String userEmail;
    private String userName;
    private String phoneNum;
    private LocalDate registerDate;
    private Integer totalObject;
    private Integer totalRent;
    private Integer totalReview;
    private Integer totalPay;
    private Integer commissionSum;
    private Integer rate;
    private Boolean isBan;
}
