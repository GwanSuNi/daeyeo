package com.daeyeo.helloDaeyeo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Builder
    public User(String email, String password, String auth) {
        this.email = email;
        this.password = password;
    }
    // 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }
    // 고유한 id 반환
    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public String getPassword() {
        return password;
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        // 만료되었는 지 확인하는 로직
        return true; // true = 만료되지 않음
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정이 잠금되었는 지 확인하는 로직
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드가 만료되었는 지 확인하는 로직
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정이 사용가능한 지 확인하는 로직
        return true;
    }
}
