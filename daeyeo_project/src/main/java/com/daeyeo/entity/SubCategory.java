package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Sub_Category")
public class SubCategory {
    @Id
    private String scId;

    @OneToMany
    @JoinColumn(name = "scId")
    private Set<RentalObject> rentalObjects = new HashSet<>();
}
