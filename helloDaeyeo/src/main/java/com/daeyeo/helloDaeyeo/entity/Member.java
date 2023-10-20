package com.daeyeo.helloDaeyeo.entity;


import com.daeyeo.helloDaeyeo.dto.memberDto.MemberUpdateDto;
import com.daeyeo.helloDaeyeo.dto.memberRegistDto.MemberRegisterDto;
import com.daeyeo.helloDaeyeo.embedded.Address;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Member")
public class Member implements UserDetails {
    @Id
    private String userEmail;
    @OneToMany(mappedBy = "member")
    Set<RentalObject> rentalObjects = new HashSet<RentalObject>();
    @OneToMany(mappedBy = "member")
    Set<RentalStatus> rentalStatuses = new HashSet<RentalStatus>();
    @Embedded
    private Address memberAddress;
    private String phone;
    private String userPw;
    private String userName;
    // 등록 날짜
    private LocalDateTime registDate;
    private String department;
    // 상태메세지
    private String statusMsg;
    // 유저가 사용한 돈
    private int paySum;
    // 유저가 벌은 돈
    private int moneyEarned;

    // 사용자 역할 정보
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Member(MemberRegisterDto memberRegisterDto) {
        this.userEmail = memberRegisterDto.getUserEmail();
        this.userPw = memberRegisterDto.getUserPw();
        this.userName = memberRegisterDto.getUserName();
        this.memberAddress = memberRegisterDto.getAddress();
        this.phone = memberRegisterDto.getPhone();
        this.department = memberRegisterDto.getDepartment();
        this.registDate = LocalDateTime.now();
    }

    public Member(MemberUpdateDto memberUpdateDto) {

    }

    @Builder
    public Member(String userEmail, Address memberAddress, String phone, String userPw, String userName, String department, LocalDateTime registDate, Set<Role> roles, String auth) {
        this.userEmail = userEmail;
        this.memberAddress = memberAddress;
        this.phone = phone;
        this.userPw = userPw;
        this.userName = userName;
        this.department = department;
        this.registDate = registDate;
        this.roles = roles;
    }

    // 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO: SimpleGrantedAuthority를 여기서 만들어야되나...?
        //현재 코드에서는 "user" 권한을 하드 코딩하여 사용자가 기본적으로 "user" 권한을 가지도록 구현되어 있습니다.
        // 이 부분을 데이터베이스 또는 사용자 엔티티에서 권한 정보를 동적으로 가져오도록 수정할 수 있습니다.
//        return List.of(new SimpleGrantedAuthority("user"));
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPw;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO: 만료되었는 지 확인하는 로직
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO: 계정이 잠금되었는 지 확인하는 로직
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO: 패스워드가 만료되었는 지 확인하는 로직
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO: 계정이 사용가능한 지 확인하는 로직
        return true;
    }
}
