package com.daeyeo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Main_Category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainCategory {
    @Id
    private String mcId;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "mcId")
    private Set<SubCategory> subCategories = new HashSet<>();

    public MainCategory(String newMcId) {
        this.mcId = newMcId;
    }

    public void addSubCategory(SubCategory subCategory) {
        this.getSubCategories().add(subCategory);
    }
}