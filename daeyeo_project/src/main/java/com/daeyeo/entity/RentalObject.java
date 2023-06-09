package com.daeyeo.entity;

import com.mysql.cj.jdbc.Blob;
import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"rentalLogs", "reviews"})
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rentalObject")
    private Set<RentalLog> rentalLogs = new HashSet<>();

    public void addRentalLog(RentalLog rentalLog) {
        this.getRentalLogs().add(rentalLog);
    }

    public RentalObject(UserEntity user, SubCategory subCategory, String objectName, int price,
                        String website, String target, LocalDate startDuration, LocalDate endDuration
            , LocalDate receiptStartDuration, LocalDate receiptEndDuration, int capacity,
                        String representNum, String useInfo, String locationInfo, String objectImage) {
        this.userEntity = user;
        this.subCategory = subCategory;
        this.objectName = objectName;
        this.price = price;
        this.website = website;
        this.target = target;
        this.startDuration = startDuration;
        this.endDuration = endDuration;
        this.receiptStartDuration = receiptStartDuration;
        this.receiptEndDuration = receiptEndDuration;
        this.capacity = capacity;
        this.representNum = representNum;
        this.useInfo = useInfo;
        this.locationInfo = locationInfo;
        this.objectImage = objectImage;
    }

    public RentalObject(UserEntity userEntity, SubCategory subCategory, String objectName, String locationInfo
            , Address address, int price, LocalDate receiptStartDuration, LocalDate receiptEndDuration
            , LocalDate startDuration, LocalDate endDuration, String representNum) {
        this.userEntity = userEntity;
        this.subCategory = subCategory;
        this.objectName = objectName;
        this.price = price;
        this.startDuration = startDuration;
        this.endDuration = endDuration;
        this.receiptStartDuration = receiptStartDuration;
        this.receiptEndDuration = receiptEndDuration;
        this.representNum = representNum;
        this.locationInfo = locationInfo;
        this.address = address;
    }

    public RentalObject(UserEntity user, SubCategory subCategory, String objectName, int price, String website, String target,String location,
                        LocalDate startDuration, LocalDate endDuration, LocalDate receiptStartDuration, LocalDate receiptEndDuration,
                        int capacity, String representNum, String useInfo, String locationInfo, String objectImage, Address address) {
        this.userEntity = user;
        this.subCategory = subCategory;
        this.objectName = objectName;
        this.price = price;
        this.website = website;
        this.target = target;
        this.location = location;
        this.startDuration = startDuration;
        this.endDuration = endDuration;
        this.receiptStartDuration = receiptStartDuration;
        this.receiptEndDuration = receiptEndDuration;
        this.capacity = capacity;
        this.representNum = representNum;
        this.useInfo = useInfo;
        this.locationInfo = locationInfo;
        this.objectImage = objectImage;
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rentalObject")
    private Set<Review> reviews = new HashSet<>();

    public void addReview(Review review) {
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
    private LocalDate receiptStartDuration;
    private LocalDate receiptEndDuration;
    private int capacity;
    private String representNum;
    @Column(length = 200)
    private String useInfo;
    @Column(length = 200)
    private String locationInfo;
    @Column(name = "objectImage", columnDefinition = "BLOB")
    private String objectImage; //BLOB임
    private int visitCount;
    @Embedded
    private Address address;
    private LocalDateTime createDate;

    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();
    }
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