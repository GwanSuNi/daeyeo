package com.daeyeo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "rentalObjects")
@Table(name = "Sub_Category")
public class SubCategory {
    @Id
    private String scId;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            mappedBy = "subCategory")
    private Set<RentalObject> rentalObjects = new HashSet<>();



    public void addRentalObject(RentalObject rentalObject){
        this.getRentalObjects().add(rentalObject);
    }

}
