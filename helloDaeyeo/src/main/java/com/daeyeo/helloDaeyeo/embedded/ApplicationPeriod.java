package com.daeyeo.helloDaeyeo.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ApplicationPeriod {
    @Column(name = "application_start_date")
    private LocalDate startDate;

    @Column(name = "application_end_date")
    private LocalDate endDate;
}