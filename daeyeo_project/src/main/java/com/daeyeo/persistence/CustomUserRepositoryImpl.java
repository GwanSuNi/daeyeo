package com.daeyeo.persistence;

import com.daeyeo.entity.BanLog;
import com.daeyeo.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity customFindMethod(String email) {
        return (UserEntity) entityManager
                .createQuery("From UserEntity u where u.userEmail = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public int memoCountByEmail(String email) {
        Long count = entityManager
                .createQuery("select count(userMemo.size) From UserEntity u where u.userEmail = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
        return count.intValue();
    }

    // TODO: Set으로 바꾸기 전에 List를 위해 BanLog를 엔티티로 만들고 PK 컬럼도 줬지만,
    //  양방향이 아니여서 조인이 불가 (BanLog 엔티티는 userEmail 컬럼을 가지고 있지 않음)
    //  따라서 양방향을 하던지, JDBC Templeate를 사용해서 테이블에서 직접 조인해야함 일단 Set으로 유지
    // .createQuery("select b.duration from UserEntity u, BanLog b where u.userEmail = :email and b.userEmail = :email order by b.duration desc ")
    @Override
    public int lastBanLogByEmail(String email) {
//        System.out.println("Last Ban Log1");
//        LocalDateTime count = (LocalDateTime) entityManager
//                .createQuery("select b.duration from UserEntity u, BanLog b where u.userEmail = :email and b.userEmail = :email order by b.duration desc ")
//                .setParameter("email", email)
//                .setMaxResults(1)
//                .getSingleResult();
//        System.out.println("Last Ban Log2");
////        return (count != null) ? count.intValue() : 0;
//        System.out.println(count);

        // 양방향일 때 이렇게도 가능
//        String query = "select u from UserEntity u left join fetch u.banLog where u.userEmail = :email";
//        UserEntity user = entityManager.createQuery(query, UserEntity.class)
//                .setParameter("email", email)
//                .getSingleResult();
//        System.out.println(user);
//        List<LocalDateTime> durations = user.getBanLog().stream()
//                .map(BanLog::getDuration)
//                .collect(Collectors.toList());
//        System.out.println(durations);
        return 0;
    }
}
