package com.daeyeo.helloDaeyeo.updateentity;

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
@Getter@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reviewIndex;
    @ManyToOne(fetch = FetchType.LAZY)
    Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    RentalObject rentalObject;
    LocalDateTime writeDate;
    String content;
    public void setMember(Member member) {
        this.member = member;
        member.getReviews().add(this);
    }
    public void setRentalObject(RentalObject rentalObject) {
        this.rentalObject = rentalObject;
        rentalObject.getReviews().add(this);
    }
    public Review(ReviewDto reviewDto){
        this.writeDate = reviewDto.getWriteDate();
        this.content = reviewDto.getContent();
    }
}
