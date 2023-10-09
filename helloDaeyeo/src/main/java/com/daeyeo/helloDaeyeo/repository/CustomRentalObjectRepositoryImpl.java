package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomRentalObjectRepositoryImpl implements CustomRentalObjectRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RentalObject> findRentalObjectsByDto(SearchSpecDto dto) {
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
        return null;
    }
}
