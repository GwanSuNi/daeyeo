package com.daeyeo.entity.ViewTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Immutable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dashboard_yearly")
public class DashBoardYearly {
    @Id
    String uuid;
    String year;
    Integer totalRentalPrice;
    Integer totalVisitCount;
    Integer totalNewUserCount;
    Integer totalReviewCount;
    Integer totalRentCount;
}
