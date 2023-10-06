package com.daeyeo.helloDaeyeo.entity;

import com.daeyeo.helloDaeyeo.dto.RentalLogDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rentalLogIndex;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rentalLogMemberId")
    Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rentalObjectId")
    RentalObject rentalObject;
    int rentalPrice;
    public void setMember(Member member) {
        this.member = member;
        member.getRentalLogs().add(this);
    }

    public void setRentalObject(RentalObject rentalObject) {
        this.rentalObject = rentalObject;
        rentalObject.getRentalLogs().add(this);
    }
    public RentalLog(RentalLogDto rentalLogDto){
        this.rentalPrice = rentalLogDto.getRentalPrice();
    }
}
