package com.daeyeo.entity;

import com.daeyeo.dto.UserDTO;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Builder
@Data
//@DynamicUpdate
@Table(name = "user")
@EqualsAndHashCode(exclude = {"rentalObjects", "rentalLogs"})
@NoArgsConstructor
@AllArgsConstructor
@SecondaryTables({
        @SecondaryTable(name = "Report_Log",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userEmail", referencedColumnName = "userEmail")
        ),
        @SecondaryTable(name = "Ban_Log",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userEmail", referencedColumnName = "userEmail")
        )}
)
public class UserEntity implements UserDetails {
    public UserEntity(String userEmail) {
        this.userEmail = userEmail;
    }
    @Id
    private String userEmail;
    private String userPw;
    private String userName;
    private String statusMsg;
    private String location;
    private String phoneNum;
    private String department;
    private String userCategory;

    private LocalDateTime registDate;

    // Embedded 였는데 수정
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "User_Memo",
            joinColumns = @JoinColumn(name = "userEmail")
    )
    @Column(name = "userMemo")
//    @OrderColumn(name = "memoId")
    private Set<UserMemo> userMemo;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "Report_Log",
            joinColumns = @JoinColumn(name = "userEmail")
    )
    private Set<ReportLog> reportLog;
    @Embedded
    private BanLog banLog;
    private int paySum;
    private int commissionSum;
    private int rate;
    private boolean quitFlag;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<RentalObject> rentalObjects = new HashSet<>();

    public void addRentalObject(RentalObject rentalObject) {
        this.getRentalObjects().add(rentalObject);
    }


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<RentalLog> rentalLogs = new HashSet<>();

    public void addRentalLog(RentalLog rentalLog) {
        this.getRentalLogs().add(rentalLog);
    }


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "Wish_List",
            joinColumns = @JoinColumn(name = "userEmail")
    )
    @MapKeyColumn(name = "objectIndex")
    @Column(name = "wishedDate")
    private Map<String, String> wishLists = new HashMap();


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer")
    private Set<Review> reviews = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "Advertisement",
            joinColumns = @JoinColumn(name = "adOwnerEmail")
    )
    @Column(name = "advertisement")
    private Set<Advertisement> advertisement = new HashSet<>();

    public void addMemoToUser(UserMemo memo) {
        this.getUserMemo().add(memo);
    }

    // 사용자의 권한을 콜렉션 형태로 반환
    // 단, 클래스 자료형은 GrantedAuthority를 구현해야함
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : userName.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return userPw;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public static UserEntity createUser(UserDTO userDTO, PasswordEncoder passwordEncoder){
        UserEntity user = UserEntity.builder()
                .userEmail(userDTO.getUserEmail())
                .userPw(passwordEncoder.encode(userDTO.getUserPw()))
                .userName(userDTO.getUserName())
                .location(userDTO.getLocation())
                .banLog(new BanLog()) // 이거 양방향으로 수정했기 때문에 변동 필요
                .build();
        return user;
    }

}
