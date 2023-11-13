package com.daeyeo.helloDaeyeo.repository;

import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.entity.Status;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import static com.daeyeo.helloDaeyeo.entity.QRentalStatus.rentalStatus;
// TODO 코드 리팩토링 나중에 해보자

public class CustomRentalStatusRepositoryImpl implements CustomRentalStatusRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<RentalStatus> statusModalSortPending(List<RentalStatus> rentalStatuses) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        OrderSpecifier<?> pending = getStatusPending("대기");
        List<RentalStatus> sortedRentalStatuses = queryFactory.
                selectFrom(rentalStatus)
                .where(rentalStatus.in(rentalStatuses).and(rentalStatus.status.eq(Status.PENDING)))
                .orderBy(pending, rentalStatus.rentalDate.asc())
                .fetch();
        return sortedRentalStatuses;
    }

    public List<RentalStatus> statusSortDate(List<RentalStatus> rentalStatuses) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<RentalStatus> sortedRentalStatuses = queryFactory.
                selectFrom(rentalStatus)
                .where(rentalStatus.in(rentalStatuses).and(rentalStatus.status.ne(Status.PENDING)))
                .orderBy(rentalStatus.rentalDate.asc())
                .fetch();
        return sortedRentalStatuses;
    }

    public List<RentalStatus> sortDate(List<RentalStatus> rentalStatusList) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<RentalStatus> sortedRentalStatuses = queryFactory.
                selectFrom(rentalStatus)
                .where(rentalStatus.in(rentalStatusList))
                .orderBy(rentalStatus.rentalDate.asc())
                .fetch();
        return sortedRentalStatuses;
    }

    public List<RentalStatus> sortDateAndRentalObject(List<RentalStatus> rentalStatusList) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<RentalStatus> sortedRentalStatuses = queryFactory.
                selectFrom(rentalStatus)
                .where(rentalStatus.in(rentalStatusList))
                .orderBy(rentalStatus.rentalDate.asc(), rentalStatus.rentalObject.objectName.asc())
                .fetch();
        return sortedRentalStatuses;
    }


    private OrderSpecifier<?> getStatusPending(String sort) {
        Order order = Order.DESC;
        if (Status.PENDING.getLabel().equals(sort)) {
            return new OrderSpecifier<>(order, rentalStatus.status);
        } else {
            return new OrderSpecifier<>(order, rentalStatus.rentalDate);
        }
    }

    private OrderSpecifier<?> getStatusNotPending(String sort) {
        Order order = Order.DESC;
        if (Status.PENDING.getLabel().equalsIgnoreCase(sort)) {
            return new OrderSpecifier<>(order, rentalStatus.status);
        } else {
            return new OrderSpecifier<>(order, rentalStatus.rentalDate);
        }
    }
}