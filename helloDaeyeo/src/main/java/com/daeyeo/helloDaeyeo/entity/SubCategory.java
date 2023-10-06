package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {
    @Id
    @Column(name = "subCategoryId")
    private String scId;
    @ManyToOne(fetch = FetchType.LAZY)
    MainCategory mainCategory;

    @OneToMany(mappedBy = "subCategory")
    Set<RentalObject> rentalObjects = new HashSet<RentalObject>();


    public SubCategory(String scId, MainCategory mainCategory) {
        this.scId = scId;
        this.mainCategory = mainCategory;
    }
}
