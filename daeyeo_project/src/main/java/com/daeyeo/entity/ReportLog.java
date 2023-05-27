package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.time.LocalDate;
@Embeddable
@Data
@Table(name = "Report_Log")
public class ReportLog {
    @Column(length = 100)
    private String reportReason;
    private LocalDate reportDate;
}
