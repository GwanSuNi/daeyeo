package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dashboard")
public class DashBoard {
    @Id
    String uuid;
    LocalDate registDate;
    Integer totalRentalPrice;
    Integer totalVisitCount;
    Integer totalNewUserCount;
    Integer totalReviewCount;

}
