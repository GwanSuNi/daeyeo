package com.daeyeo.service;

import com.daeyeo.command.RentalListCmd;
import com.daeyeo.entity.Address;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.entity.UserEntity;
import com.daeyeo.persistence.CustomRentalObjectRepositoryImpl;
import com.daeyeo.persistence.RentalObjectRepository;
import com.daeyeo.persistence.SubCategoryRepository;
import com.daeyeo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Service("rentalObjectService")
public class RentalObjectService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private RentalObjectRepository rentalObjectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomRentalObjectRepositoryImpl customRentalObjectRepository;

    public SubCategory findSubCategoryByScId(String scId){
        Optional<SubCategory> subCategory = subCategoryRepository.findByScId(scId);
        return subCategory.orElse(null);
    }

    public UserEntity findEntityById(String email) {
        Optional<UserEntity> userEntity = userRepository.findByUserEmail(email);
        return userEntity.orElse(null);
    }
    public List<RentalObject> findAll(){
        return rentalObjectRepository.findAll();
    }



    /**
     * @auther 서상현
     * RentalObject를 만드는 메서드입니다. 기본키는 AutoIncrement를 적용해서 매개변수로 값을 넣어주지않았고 ,
     * 외래키는 양방향 관계로 인해 값을 둘다 넣어줘야하기때문에 userEmail과 scId를 넣었습니다
     * @param ownerEmail UserEntity에서 갖고온 외래키입니다
     * @param scId Sub Category에서 갖고온 외래키입니다.
     */
    public void insertRentalObject(String ownerEmail , String scId, String objectName, int price,
                                   String website , String target , LocalDate startDuration ,
                                   LocalDate endDuration, LocalDateTime receiptDuration , int capacity ,
                                   String representNum , String userInfo , String locationInfo, String objectImage
            ,Address address){
        UserEntity userEntity = userRepository.findByUserEmail(ownerEmail).get();
        SubCategory subCategory = subCategoryRepository.findByScId(scId).get();

//         RentalObject rentalObject = new RentalObject(userEntity, subCategory , objectName, price ,website,
//                 target,startDuration,endDuration,receiptDuration,capacity,representNum,userInfo,locationInfo,
//                 objectImage);/
//        rentalObject.setAddress(address);
//        userEntity.addRentalObject(rentalObject);
//        subCategory.addRentalObject(rentalObject);
//        rentalObjectRepository.save(rentalObject);
    }
    public void insertRentalObjectReal(String scId, String ownerEmail ,String objectName, String locationInfo,
                                       Address address, int price , LocalDate receipStartDuration, LocalDate receiptEndDuration, LocalDate startDuration,
                                       LocalDate endDuration , String representNum){
        UserEntity userEntity = userRepository.findByUserEmail(ownerEmail).get();
        SubCategory subCategory = subCategoryRepository.findByScId(scId).get();
        RentalObject newRentalObject = new RentalObject(userEntity,subCategory,objectName,locationInfo,
                address,price,receipStartDuration,receiptEndDuration,startDuration,endDuration,representNum);
        newRentalObject.setAddress(address);
        userEntity.addRentalObject(newRentalObject);
        subCategory.addRentalObject(newRentalObject);
        rentalObjectRepository.save(newRentalObject);
        // mysql에 있는 createDate는 신경쓰지 않아도 됩니다
    }

    /**
     * 렌탈오브젝트를 삭제하는 메서드입니다 삭제하면서 값 찾아오는것도 해놓음
     * @author 서상현
     * @param objectIndex 기본키입니다
     * @param scId SubCategory 에서 갖고온 외래키입니다.
     * @param ownerEmail
     */
    public void deleteRentalObject(int objectIndex ,String ownerEmail, String scId ){
        SubCategory subCategory = subCategoryRepository.findByScId(scId).get();
        UserEntity userEntity = userRepository.findByUserEmail(ownerEmail).get();
        Optional<RentalObject> rentalObject  = rentalObjectRepository.findByObjectIndexAndSubCategoryAndUserEntity(objectIndex,subCategory,userEntity);
        rentalObjectRepository.delete(rentalObject.get());
    }

    /**
     *  Rental Object 값 찾아오는 메서드
     */
    public Optional<RentalObject> findRentalObject(int objectIndex , String scId , String ownerEmail){
        SubCategory subCategory = subCategoryRepository.findByScId(scId).get();
        UserEntity user = userRepository.findByUserEmail(ownerEmail).get();
        Optional<RentalObject> rentalObject  = rentalObjectRepository.findByObjectIndexAndSubCategoryAndUserEntity(objectIndex,subCategory,user);
        return rentalObject;
    }

    /**
     *
     * @param rentalListCmd
     * @return
     */
    public List<RentalObject> findRentalObjectByCommand(RentalListCmd rentalListCmd) {
        return customRentalObjectRepository.findRentalObjectByCommand(rentalListCmd);
    }

//TODO : 기본키 외래키 바꿔야 할 값을 모두 받아온후에 값 검증을 하기
    /**
     *
     * @param objectIndex RentalObject 에서 만든 기본키입니다 Auto increament를 적용한 값
     * @param scId SubCategory에서 만든 외래키입니다
     * @param ownerEmail User에서 만든 기본키입니다
     */
    public void updateRentalObject(int objectIndex , String scId , String ownerEmail ,String objectName , int price,
                                   String website ,String target, LocalDate startDuration, LocalDate endDuration,
                                   LocalDateTime receiptDuration , int capacity , String representNum , String userInfo,
                                   String locationInfo , String objectImage) {
        RentalObject changeRentalObject = new RentalObject();
        Optional<RentalObject> oldRentalObject = rentalObjectRepository.findByObjectIndex(objectIndex);
        if(oldRentalObject!=null){
            changeRentalObject.setObjectIndex(objectIndex);
            SubCategory subCategory = subCategoryRepository.findByScId(scId).get();
            changeRentalObject.setSubCategory(subCategory);
            UserEntity userEntity = userRepository.findByUserEmail(ownerEmail).get();
            changeRentalObject.setUserEntity(userEntity);
            changeRentalObject.setObjectName(objectName);
            changeRentalObject.setPrice(price);
            changeRentalObject.setWebsite(website);
            changeRentalObject.setTarget(target);
            changeRentalObject.setStartDuration(startDuration);
            changeRentalObject.setEndDuration(endDuration);
//            changeRentalObject.setReceiptDuration(receiptDuration);
            changeRentalObject.setCapacity(capacity);
            changeRentalObject.setRepresentNum(representNum);
            changeRentalObject.setUserInfo(userInfo);
            changeRentalObject.setLocationInfo(locationInfo);
            changeRentalObject.setObjectImage(objectImage);
            rentalObjectRepository.save(changeRentalObject);
        }
        else{
            // 기본키 값이 없을때 값을 추가하는게 나을지 아닐지 프리젠테이션레이아웃할때 결정
        }
//        if(subCategory != null){ // null 값이 아닐경우 값 넣기
//
//        }
//        else{  null 값일 경우 화면에서 적용해서 에러메세지 띄우기
//
//        }
//          if(userEntity != null){ // Null 값이 아닌경우 값 넣기
//
//          }
//          else{   null 값일 경우 화면에서 적용해서 에러메세지 띄우기
//
//          }
    }


    public void insertSubCategory(SubCategory subCategory){
        try {
            subCategoryRepository.save(subCategory);
        } catch (Exception e) {
            System.err.println("Error occurred while inserting SubCategory: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void insertEntityUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

//    public MainCategory findMainCategoryById(String id){
//        Optional<MainCategory> mainCategory = mainCategoryRepository.findByMcId(id);
//        return mainCategory.orElse(null);
//    }

//    public SubCategory findBySubCategoryById(String scId){
//        Optional<SubCategory> subCategory = subCategoryRepository.findByScId(scId);
//        return subCategory.orElse(null);
//    }


}
