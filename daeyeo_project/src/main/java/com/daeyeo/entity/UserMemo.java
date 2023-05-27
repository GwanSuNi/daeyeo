package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.time.LocalDate;
@Embeddable
@Data
@Table(name = "User_Memo")
public class UserMemo {
    private String content;
    private LocalDate memoDate;
}
