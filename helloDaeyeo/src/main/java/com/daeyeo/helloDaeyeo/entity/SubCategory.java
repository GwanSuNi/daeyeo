package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SubCategory {
    @Id
    private String scId;

    @ManyToOne(fetch = FetchType.LAZY)
    MainCategory mainCategory;

    @OneToMany(mappedBy = "subCategory")
    List<RentalObject> rentalObjects = new ArrayList<>();

    public SubCategory(String scId, MainCategory mainCategory) {
        this.scId = scId;
        this.mainCategory = mainCategory;
    }
}
