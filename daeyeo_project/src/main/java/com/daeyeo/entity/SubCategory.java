package com.daeyeo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "rentalObjects")
@Table(name = "sub_category")
public class SubCategory {
    @Id
    private String scId;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            mappedBy = "subCategory")
    private Set<RentalObject> rentalObjects = new HashSet<>();

    public void addRentalObject(RentalObject rentalObject){
        this.getRentalObjects().add(rentalObject);
    }
}
