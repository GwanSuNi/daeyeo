package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalStatusId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userRentalStatus")
    Member userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objectRentalStatus")
    RentalObject rentalObjectId;
    @OneToMany(mappedBy = "rentalStatus")
    List<RentalLog> rentalLogs = new ArrayList<RentalLog>();
    @Enumerated(EnumType.STRING)
    private Status status;

    public void setMember(Member member) {
        this.userId = member;
        member.getRentalStatuses().add(this);
    }

    public void setRentalObject(RentalObject rentalObject) {
        this.rentalObjectId = rentalObject;
        rentalObject.getRentalStatuses().add(this);
    }
}
