package com.daeyeo.persistence;

import com.daeyeo.entity.BanLog;
import com.daeyeo.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
// JPQL 사용하는 애들만 여기다가 ~
// TODO: 엔티티별로 구분해서 클래스 분리
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

    //TODO: Service에서 호출하도록 구조화
    /**
     * 해당 유저의 메모가 몇 개인지 구하는 메서드
     * @param email
     * @return 메모 개수
     */
    @Override
    public int memoCountByEmail(String email) {
        Long count = entityManager
                .createQuery("select count(userMemo.size) From UserEntity u where u.userEmail = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
        return count.intValue();
    }

    /**
     * 이 메서드를 다시 사용하는 메서드는 로그인 과정에서 수행되어 banLog의 가장 max()의 duration의 값의 flag가 true일 시 로그인 불가
     * 가장 최근 밴로그를 불러오는 메서드
     * 양방향 설정을 해줬기 때문에, userEmail에 접근 가능
     *
     * @param email
     * @return BanLog 레코드
     */
    @Override
    public BanLog getLastBanLogByEmail(String email) {
        BanLog result = entityManager
                .createQuery("select b from BanLog b where b.userEntity.userEmail = :email order by b.duration desc ", BanLog.class)
                .setParameter("email", email)
                .setMaxResults(1)
                .getSingleResult();
        System.out.println("Last Ban Log");
        entityManager.merge(result);
        System.out.println(result);
        return result;
    }

}
