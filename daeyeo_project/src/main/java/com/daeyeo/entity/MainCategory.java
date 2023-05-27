package com.daeyeo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Main_Category")
@Data
public class MainCategory {
    @Id
    private String mcId;
    @OneToMany
    @JoinColumn(name = "mcId")
    private Set<SubCategory> subCategories = new HashSet<>();


    protected MainCategory() {
    }
    public MainCategory(String mcId, Set<String> scId) {
        this.mcId = mcId;
    }

    public String getMcId() {
        return mcId;
    }
    public void setMcId(String mcId) {
        this.mcId = mcId;
    }

}
