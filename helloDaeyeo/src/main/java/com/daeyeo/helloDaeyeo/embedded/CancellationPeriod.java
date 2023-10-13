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
public class CancellationPeriod {
    @Column(name = "cancellation_start_date")
    private LocalDate startDate;

    @Column(name = "cancellation_end_date")
    private LocalDate endDate;
}
