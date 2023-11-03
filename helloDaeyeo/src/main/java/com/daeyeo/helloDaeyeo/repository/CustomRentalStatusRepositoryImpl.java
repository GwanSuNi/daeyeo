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

public class CustomRentalStatusRepositoryImpl implements CustomRentalStatusRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<RentalStatus> statusSort(List<RentalStatus> rentalStatuses) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
//        EnumPath<Status> statusType = rentalStatus.status;
        OrderSpecifier<?> orderSpecifier = getOrderSpecifier("대기");

        List<RentalStatus> sortedRentalStatuses = queryFactory.
                selectFrom(rentalStatus)
                .where(rentalStatus.in(rentalStatuses))
                .orderBy(
                        orderSpecifier
                )
                .fetch();

        return sortedRentalStatuses;
    }

    private OrderSpecifier<?> getOrderSpecifier(String sort) {
        Order order = Order.DESC;
        if (Status.PENDING.getLabel().equals(sort)) {
            return new OrderSpecifier<>(order, rentalStatus.status);
        } else {
            return new OrderSpecifier<>(order, rentalStatus.rentalDate);
        }
    }

//    private List<OrderSpecifier<?>> getOrderSpecifiers(String sort) {
//        List<OrderSpecifier<?>> orderSpecifiers = new ArrayList<>();
//        if (Status.PENDING.getLabel().equals(sort)) {
//            orderSpecifiers.add(new OrderSpecifier<>(Order.DESC, rentalStatus.status));
//        }
//        orderSpecifiers.add(new OrderSpecifier<>(Order.ASC, rentalStatus.rentalDate));
//        return orderSpecifiers;
//    }

    //
    public List<RentalStatus> statusSortPending(List<RentalStatus> rentalStatuses) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        OrderSpecifier<?> pending = getOrderSpecifier("대기");
        List<RentalStatus> sortedRentalStatuses = queryFactory.
                selectFrom(rentalStatus)
                .where(rentalStatus.in(rentalStatuses))
//                .orderBy(pending, rentalStatus.rentalDate.asc())
                .orderBy(rentalStatus.status.eq(Status.PENDING).desc(),
                        rentalStatus.rentalDate.asc())
                .fetch();

        return sortedRentalStatuses;
    }
}
//
//
//}
