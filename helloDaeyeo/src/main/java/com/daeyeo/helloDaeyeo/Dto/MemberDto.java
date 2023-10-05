package com.daeyeo.helloDaeyeo.Dto;

import com.daeyeo.helloDaeyeo.Entity.RentalObject;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String userId;
    private String userPw;
    private String userEmail;
    private String userName;
}
