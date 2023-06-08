package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User_Memo")
public class UserMemo {
    @Column(name = "memoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memoId;
    private String content;
    private LocalDateTime memoDate;

    public UserMemo(String content) {
        this.content = content;
        this.memoDate = LocalDateTime.now();
    }

    public UserMemo(int memoId, String content) {
        this.memoId = memoId;
        this.content = content;
        this.memoDate = LocalDateTime.now();
    }

}
