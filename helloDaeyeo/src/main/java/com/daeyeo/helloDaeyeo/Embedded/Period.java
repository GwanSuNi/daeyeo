package com.daeyeo.helloDaeyeo.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

public class Period {
    private LocalDateTime registStart;
    private LocalDateTime registEnd;

    private LocalDateTime usageStart;
    private LocalDateTime usageEnd;

}
