package com.daeyeo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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
public class User {
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
    private boolean flag;
    @OneToMany
    @JoinColumn(name="ownerEmail")
    private Set<RentalObject> rentalObjects = new HashSet<>();

    @OneToMany
    @JoinColumn(name="userEmail")
    private Set<WishList> wishLists = new HashSet<>();

    @OneToMany
    @JoinColumn(name="targetUser")
    private Set<RentalLog> rentalLogs = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "writer")
    private Set<Review> reviews = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name ="Advertisement",
            joinColumns = @JoinColumn(name ="ownerEmail")
    )
    @Column(name = "adId")
    private Set<Advertisement> advertisement = new HashSet<>();
}
