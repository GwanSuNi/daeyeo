package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class MainCategory {
    @Id
    @Setter
    private String mcId;

    public MainCategory(String mcId) {
        this.mcId = mcId;
    }
}
