package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class SubCategory {
    @Id
    private String scId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    MainCategory mainCategory;

    @OneToMany(mappedBy = "subCategory")
    Set<RentalObject> rentalObjects = new HashSet<RentalObject>();

    public SubCategory(String scId, MainCategory mainCategory) {
        this.scId = scId;
        this.mainCategory = mainCategory;
    }
}
