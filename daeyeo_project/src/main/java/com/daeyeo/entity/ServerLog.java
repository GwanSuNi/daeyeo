package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "server_log")
public class ServerLog {
    @Id
    private int id;
    private LocalDateTime logDate;
    @Column(length=40)
    private String userEmail;
    @Column(length=40)
    private String ipAddress;
    @Column(length=50)
    private String eventContent;

}
