package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@Table(name = "User")
@NoArgsConstructor
@SecondaryTables({
        @SecondaryTable(name = "User_Memo",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userEmail", referencedColumnName = "userEmail")
        ),
        @SecondaryTable(name = "Report_Log",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userEmail", referencedColumnName = "userEmail")
        ),
        @SecondaryTable(name = "Ban_Log",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userEmail", referencedColumnName = "userEmail")
        )}
)
public class UserEntity {
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
    @Embedded
    private UserMemo userMemo;
    @Embedded
    private ReportLog reportLog;
    @Embedded
    private BanLog banLog;
    private int paySum;
    private int commissionSum;
    private int rate;
    private boolean quitFlag;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="ownerEmail")
    private Set<RentalObject> rentalObjects = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "Wish_List",
            joinColumns = @JoinColumn(name = "userEmail")
    )
    @MapKeyColumn(name = "objectIndex")
    @Column(name = "wishedDate")
    private Map<String, String> wishLists = new HashMap();

    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name="targetUser")
    private Set<RentalLog> rentalLogs = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer")
    private Set<Review> reviews = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name ="Advertisement",
            joinColumns = @JoinColumn(name ="adOwnerEmail")
    )
    @Column(name = "advertisement")
    private Set<Advertisement> advertisement = new HashSet<>();
}
