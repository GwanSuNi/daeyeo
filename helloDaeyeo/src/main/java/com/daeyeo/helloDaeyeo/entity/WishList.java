package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long wishIndex;
    @ManyToOne
    Member member;
    @ManyToOne
    RentalObject rentalObject;

    public void setMember(Member member) {
        this.member = member;
        if (member != null) {
            member.getWishListList().add(this);
        }
    }

    public void setRentalObject(RentalObject rentalObject) {
        this.rentalObject = rentalObject;
        if (rentalObject != null) {
            rentalObject.getWishListList().add(this);
        }
    }
}
