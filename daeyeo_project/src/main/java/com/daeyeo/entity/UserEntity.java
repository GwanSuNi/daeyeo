package com.daeyeo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString(exclude = {"banLogs"})
//@DynamicUpdate
@Table(name = "user")
@EqualsAndHashCode(exclude = {"rentalObjects", "rentalLogs", "banLogs", "reviews","wishLists"})
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
    private Address address; //TODO: location 컬럼 보류
    private String phoneNum;
    private String department;
    private String userCategory;

    private LocalDate registDate;

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
    private List<BanLog> banLogs = new ArrayList<>();

    public void addBanLog(BanLog banLog) {
        this.getBanLogs().add(banLog);
        banLog.addUserEntity(this);
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

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,mappedBy = "userEntity")
    private Set<WishList> wishLists = new HashSet<>();
    public void addWishList(WishList wishList){
        this.getWishLists().add(wishList);
    }
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(
//            name = "Wish_List",
//            joinColumns = @JoinColumn(name = "userEmail")
//    )
//    @OrderColumn(name = "wishIndex")
//    private List<WishList> wishLists = new ArrayList<>();

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
    public boolean checkUserEmail(String userEmail){
        return this.userEmail.equals(userEmail);
    }
    public boolean checkPassword(String userPw){
        return this.userPw.equals(userPw);
    }
}
