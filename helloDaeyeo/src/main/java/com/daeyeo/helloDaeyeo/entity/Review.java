package com.daeyeo.helloDaeyeo.entity;

import com.daeyeo.helloDaeyeo.dto.ReviewDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {
    // 연관관계의 주인 OneToOne 양방향 관계에서 키의 주인을 설정해야하는데 키의 주인을 Review로 설정함
    // mappedBy 속성이 없는 곳이 키의 주인이라고 생각하면 됨
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reviewIndex;
    @OneToOne(mappedBy = "review")
    private RentalStatus rentalStatus;
    LocalDateTime writeDate;
    String content;

    public Review(ReviewDto reviewDto) {
        this.writeDate = reviewDto.getWriteDate();
        this.content = reviewDto.getContent();
    }
}
