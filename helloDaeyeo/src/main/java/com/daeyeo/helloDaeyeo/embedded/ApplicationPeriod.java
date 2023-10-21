package com.daeyeo.helloDaeyeo.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class ApplicationPeriod {
    @Column(name = "application_start_date")
    private LocalDate startDate;

    @Column(name = "application_end_date")
    private LocalDate endDate;
}