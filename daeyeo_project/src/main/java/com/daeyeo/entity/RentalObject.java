package com.daeyeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"rentalLogs","reviews"})
@Table(name = "Rental_Object")
public class RentalObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int objectIndex;

    @ManyToOne
    @JoinColumn(name = "ownerEmail")
    // 이건 우리가 외래키로 설정한 값을 넣어야함 즉 Rental_Object 설정 이름을 넣어야함
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "scId")
    private SubCategory subCategory;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "rentalObject")
    private Set<RentalLog> rentalLogs = new HashSet<>();
    public void addRentalLog(RentalLog rentalLog){
        this.getRentalLogs().add(rentalLog);
    }

    public RentalObject(UserEntity user , SubCategory subCategory , String objectName, int price,
                         String website , String target , LocalDate startDuration , LocalDate endDuration
            , LocalDateTime receiptDuration , int capacity , String representNum , String userInfo , String locationInfo
            ,String objectImage ){

        this.userEntity=user;
        this.subCategory=subCategory;
        this.objectName = objectName;
        this.price=price;
        this.website=website;
        this.target=target;
        this.startDuration=startDuration;
        this.endDuration=endDuration;
        this.receiptDuration=receiptDuration;
        this.capacity=capacity;
        this.representNum= representNum;
        this.userInfo=userInfo;
        this.locationInfo=locationInfo;
        this.objectImage=objectImage;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL , mappedBy = "rentalObject")
    private Set<Review> reviews = new HashSet<>();
    public void addReview(Review review){
        this.getReviews().add(review);
    }

//    @Column(length = 20)
//    //외래키
//    private String scId;

    //    @Column(length = 40)
//    //외래키
//    private String ownerEmail;

    //    @OneToMany
//    @JoinColumn(name="objectIndex")
//    private Set<WishList> wishLists = new HashSet<>();
    @Column(length = 40)
    private String objectName;
    private int price;
    private int wishCount;
    @Column(length = 255)
    private String website;
    @Column(length = 100)
    private String target;
    @Column(length = 100)
    private String location;
    private LocalDate startDuration;
    private LocalDate endDuration;
    private LocalDateTime receiptDuration;
    private int capacity;

    private String representNum;
    @Column(length = 200)
    private String userInfo;
    @Column(length = 200)
    private String locationInfo;
    private String objectImage; //BLOB임
    private int visitCount;
    @Embedded
    private Address address;


}







//import lombok.Data;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Data
//@Table(name = "Rental_Object")
//public class RentalObject {
//    @Id
//    private int objectIndex;
//
////    @Column(length = 20)
////    //외래키
////    private String scId;
//
////    @Column(length = 40)
////    //외래키
////    private String ownerEmail;
//    @OneToMany
//    @JoinColumn(name="objectIndex")
//    private Set<WishList> wishLists = new HashSet<>();
//
//    @OneToMany
//    @JoinColumn(name="targetObject")
//    private Set<RentalLog> rentalLogs = new HashSet<>();
//
//
//    @Column(length = 40)
//    private String objectName;
//    private int price;
//    private int wishCount;
//    @Column(length = 255)
//    private String website;
//    @Column(length = 100)
//    private String target;
//    @Column(length = 100)
//    private String location;
//    private LocalDate startDuration;
//    private LocalDate endDuration;
//    private LocalDateTime receiptDuration;
//    private int capacity;
//
//    private int representNum;
//    @Column(length = 200)
//    private String userInfo;
//    @Column(length = 200)
//    private String locationInfo;
//    private String objectImage; //BLOB임
//}