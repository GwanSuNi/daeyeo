package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
//@DynamicUpdate
@Table(name = "User")
@EqualsAndHashCode(exclude = {"rentalObjects", "rentalLogs"})
@NoArgsConstructor
@SecondaryTables({
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

    // Embedded 였는데 수정
    @ElementCollection (fetch = FetchType.EAGER)
    @CollectionTable(
            name = "User_Memo",
            joinColumns = @JoinColumn(name ="userEmail")
    )
    @Column(name = "userMemo")
//    @OrderColumn(name = "memoId")
    private Set<UserMemo> userMemo;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable (
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

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<RentalObject> rentalObjects = new HashSet<>();
    public void addRentalObject(RentalObject rentalObject){
        this.getRentalObjects().add(rentalObject);
    }


    @OneToMany (fetch = FetchType.EAGER , cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<RentalLog> rentalLogs = new HashSet<>();
    public void addRentalLog(RentalLog rentalLog) { this.getRentalLogs().add(rentalLog);  }




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
            name ="Advertisement",
            joinColumns = @JoinColumn(name ="adOwnerEmail")
    )
    @Column(name = "advertisement")
    private Set<Advertisement> advertisement = new HashSet<>();

    public void addMemoToUser(UserMemo memo) {
        this.getUserMemo().add(memo);
    }
}
