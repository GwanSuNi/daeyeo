//package com.daeyeo.helloDaeyeo.Repository;
//
//import com.daeyeo.helloDaeyeo.Entity.Member;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class MemberRepository implements MemberRepositoryBasic {
//    @Autowired
//    MemberRepositoryBasic memberRepositoryBasic;
//
//    public String changeName(Member member){
//        member = memberRepositoryBasic.findById(member.getId());
//        member.setUserName("바뀌었어요");
//        memberRepositoryBasic.save(member);
//        return member.getUserName();
//    }
//
////    @PersistenceContext
////    private EntityManager em;
////
////    public Long save(Member member){
////        em.persist(member);
////        return member.getId();
////    }
////    public Member find(Long id){
////        return em.find(Member.class , id);
////    }
//
//}
