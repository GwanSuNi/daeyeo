package com.daeyeo.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@ToString(exclude = {"banLog"})
//@DynamicUpdate
@Table(name = "User")
@EqualsAndHashCode(exclude = {"rentalObjects", "rentalLogs", "banLogs", "reviews"})
@NoArgsConstructor
@SecondaryTables({
        @SecondaryTable(name = "Report_Log",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "userEmail", referencedColumnName = "userEmail")
        )
})
public class UserEntity {
    public UserEntity(String userEmail) {
        this.userEmail = userEmail;
    }

    @Id
    private String userEmail;
    private String userPw;
    private String userName;
    private String statusMsg;
    @Embedded
    private Address location;
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
    //    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(
//            name = "Ban_Log",
//            joinColumns = @JoinColumn(name = "userEmail")
//    )
//    @OrderColumn(name = "banId")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userEntity")
    @OrderColumn(name = "banId")
    private List<BanLog> banLogs = new ArrayList<>(); // TODO: List로 변환

    public void addBanLog(BanLog banLog) {
        this.getBanLogs().add(banLog);
    }

    private int paySum;
    private int commissionSum;
    private int rate;
    private boolean quitFlag;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<RentalObject> rentalObjects = new HashSet<>();

    public void addRentalObject(RentalObject rentalObject) {
        this.getRentalObjects().add(rentalObject);
    }

    @OneToMany (fetch = FetchType.LAZY , cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<RentalLog> rentalLogs = new HashSet<>();
    public void addRentalLog(RentalLog rentalLog) { this.getRentalLogs().add(rentalLog);  }

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "userEntity")
    private Set<Review> reviews = new HashSet<>();
    public void addReview(Review review){this.getReviews().add(review);}

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "Wish_List",
            joinColumns = @JoinColumn(name = "userEmail")
    )
    @MapKeyColumn(name = "objectIndex")
    @Column(name = "wishedDate")
    private Map<String, String> wishLists = new HashMap();

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
}
