package com.daeyeo.helloDaeyeo.embedded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class UsagePeriod {
    @Column(name = "usage_start_date")
    private LocalDate startDate;

    @Column(name = "usage_end_date")
    private LocalDate endDate;

    @Column(name = "usage_start_time")
    private LocalTime startTime;

    @Column(name = "usage_end_time")
    private LocalTime endTime;
}
