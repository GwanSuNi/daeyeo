package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MainCategory {
    @Id
    private String mcId;

    public MainCategory(String mcId) {
        this.mcId = mcId;
    }
}
