package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.time.LocalDate;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User_Memo")
public class UserMemo {
    private String content;
    private LocalDate memoDate;
}
