package com.daeyeo.helloDaeyeo.repository;


import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static com.daeyeo.helloDaeyeo.entity.QRentalObject.rentalObject;
import static com.daeyeo.helloDaeyeo.entity.QSubCategory.subCategory;


@Repository
public class CustomRentalObjectRepositoryImpl implements CustomRentalObjectRepository {
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * 검색조건과 정렬조건을 매개변수로 받아와서 동적쿼리 실행 해당 변수에대해서 if문을 하나씩 거치면서 필터를 함
     * @param dto 검색조건 ,정렬조건을 받아오는 매개변수
     * @return
     */
    @Override
    public List<RentalObject> findRentalObjectsByDto(SearchSpecDto dto) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        JPAQuery<RentalObject> query = queryFactory.selectFrom(rentalObject);
        // 검색조건을 합치기위한 BooleanExpression BolleanBuilder 패턴도 있는데 이거에대해선 프로젝트 끝난후 찾아보자
        BooleanExpression conditions = null;
        //
        if (dto.getMainCategory() != null) {
            BooleanExpression mainCategoryCondition = rentalObject.subCategory.mainCategory.mcId.eq(dto.getMainCategory());
            conditions = (conditions != null) ? conditions.and(mainCategoryCondition) : mainCategoryCondition;
        }

        if (dto.getSubCategory() != null) {
            BooleanExpression subCategoryCondition = rentalObject.subCategory.scId.eq(dto.getSubCategory());
            conditions = (conditions != null) ? conditions.and(subCategoryCondition) : subCategoryCondition;
        }

        if (dto.getSido() != null) {
            BooleanExpression sidoCondition = rentalObject.address.address.contains(dto.getSido());
            conditions = (conditions != null) ? conditions.and(sidoCondition) : sidoCondition;
        }

        if (dto.getSigungu() != null) {
            BooleanExpression sigunguCondition = rentalObject.address.extraAddress.contains(dto.getSigungu());
            conditions = (conditions != null) ? conditions.and(sigunguCondition) : sigunguCondition;
        }

        if (dto.getSearchWord() != null) {
            BooleanExpression searchWordCondition = rentalObject.objectName.contains(dto.getSearchWord());
            conditions = (conditions != null) ? conditions.and(searchWordCondition) : searchWordCondition;
        }
        // 모든 조건을 조합하여 하나의 쿼리로 생성 쿼리로 생성함과 동시에 페이징처리와 검색정렬까지 함
        if (conditions != null) {
//            dto.getSort() 매개변수는 어떤 열을 기준으로 정렬할지를 문자열로 나타내며,
//            ascending 매개변수는 정렬 방향을 나타내는 부울 값이다

            // 동적 정렬 조건 생성 정렬조건이 들어왔을때만 정렬함
            if(dto.getSort() != null){
            OrderSpecifier<?> orderSpecifier = getOrderSpecifier(dto.getSort());
            List<RentalObject> rentalObjectList = query.innerJoin(rentalObject.subCategory, subCategory)
                    .where(conditions)
                    .orderBy(orderSpecifier)
                    .fetch();
                return rentalObjectList;
            } else{
                List<RentalObject> rentalObjectList = query.innerJoin(rentalObject.subCategory, subCategory)
                        .where(conditions)
                        .fetch();
                return rentalObjectList;
            }

        } else {
            // 모든 조건이 null일 경우 처리
            List<RentalObject> rentalObjectList = query.fetch();
            return rentalObjectList;
        }
    }

    /***
     * OrderSpecifier 은 querydsl 에서 정렬을 지정하는데 사용한다
     * Order order = Order.ASC; 이 코드는 정렬하는 조건에대해서 정럴을 시도했을떄 오름차순으로 할거냐 내림차순으로 할거냐 물어보는것
     * 그래서 난 오름차순으로 한다고 함
     * @param sort 검색조건을 입력받았을때
     * @return
     */
    private OrderSpecifier<?> getOrderSpecifier(String sort) {
        Order order = Order.DESC;
        if ("receipt".equals(sort)) {
            // 정렬 조건 - 접수 기간
            return new OrderSpecifier<>(order, rentalObject.applicationPeriod.startDate);
        } else if ("usage".equals(sort)) {
            // 정렬 조건 - 이용 기간
            return new OrderSpecifier<>(order, rentalObject.usagePeriod.startDate);
        } else if ("region".equals(sort)) {
            // 동적 정렬 조건 - 주소명
            return new OrderSpecifier<>(order, rentalObject.address.sido);
        } else {
            // 기본 정렬 조건
            return new OrderSpecifier<>(order, rentalObject.objectName);
        }
    }

    /***
     * 가공된(정렬 , 필터) RentalObject를 매개변수로 받아와서 페이징처리하는 메서드
     * @param pageable 페이징에 필요한 변수들 갖고있음
     * @param rentalObjectList 가공된 rentalObjectList
     * @return
     */
    public Page<RentalObject> findRentalObjectsByPage(Pageable pageable , List<RentalObject> rentalObjectList){
        int pageSize = pageable.getPageSize(); // 한 페이지에 표시할 아이템 수
        int currentPage = pageable.getPageNumber(); // 현재 페이지의 번호
        int startItem = currentPage * pageSize; //

        List<RentalObject> pageList;

        if (startItem < rentalObjectList.size()) {
            int toIndex = Math.min(startItem + pageSize, rentalObjectList.size());
            pageList = rentalObjectList.subList(startItem, toIndex);
        } else {
            pageList = Collections.emptyList();
        }

        return new PageImpl<>(pageList, pageable, rentalObjectList.size());
    }
}
//    }
//}

//        if (dto.getMainCategory() != null)  {
//            query.innerJoin(rentalObject.subCategory, subCategory)
//                    .where(subCategory.mainCategory.mcId.eq(dto.getMainCategory()));
//        }
//
//        if (dto.getSubCategory() != null) {
//            query.innerJoin(rentalObject.subCategory, subCategory)
//                    .where(subCategory.scId.eq(dto.getSubCategory()));
//        }
//
//        if (dto.getSido() != null) {
//            query.where(rentalObject.address.address.eq(dto.getSido()));
//        }
//
//        if (dto.getSigungu() != null) {
//            query.where(rentalObject.address.extraAddress.eq(dto.getSigungu()));
//        }
//
//        if (dto.getSearchWord() != null) {
//            query.where(rentalObject.objectName.contains(dto.getSearchWord()));
//        }
//                    .or(rentalObject..contains(dto.getSearchWord())));
        /*
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RentalObject> criteriaQuery = criteriaBuilder.createQuery(RentalObject.class);
        // MainCategory와 RentalObject를 조인하기 위하여 먼저 MainCategory와 SubCategory를 조인하고 그다음에 SubCategory와 RentalObject를 조인함
        Root<MainCategory> root = criteriaQuery.from(MainCategory.class);
        Join<MainCategory, SubCategory> join1 = root.join("subCategories", JoinType.INNER);
        Join<SubCategory, RentalObject> join2 = join1.join("rentalObjects", JoinType.INNER);
        List<Predicate> predicates = new ArrayList<>();

        criteriaQuery.select(join2);

        if (!rentalListCmd.getMainCate().equals("")) // 검색 조건에 대분류가 있는 경우
            predicates.add(criteriaBuilder.equal(root.get("mcId"), rentalListCmd.getMainCate()));
        if (!rentalListCmd.getSubCate().equals("")) // 검색 조건에 소분류가 있는 경우
            predicates.add(criteriaBuilder.equal(join1.get("scId"), rentalListCmd.getSubCate()));
        if (!rentalListCmd.getSido().equals("")) // 검색 조건에 시/도가 있는 경우
            predicates.add(criteriaBuilder.equal(join2.get("address").get("sido"), rentalListCmd.getSido()));
        if (!rentalListCmd.getSigungu().equals("")) // 검색 조건에 시/군/구가 있는 경우
            predicates.add(criteriaBuilder.equal(join2.get("address").get("sigungu"), rentalListCmd.getSigungu()));
        if (!rentalListCmd.getSearchWord().equals("")) { // 검색 조건에 검색어가 있는 경우
            predicates.add(criteriaBuilder.or(criteriaBuilder.like(join2.get("objectName"), "%" + rentalListCmd.getSearchWord() + "%"), criteriaBuilder.like(join2.get("locationInfo"), "%" + rentalListCmd.getSearchWord() + "%")));
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

        TypedQuery<RentalObject> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
*/
