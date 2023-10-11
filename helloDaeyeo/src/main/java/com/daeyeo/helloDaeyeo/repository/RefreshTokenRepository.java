//package com.daeyeo.helloDaeyeo.repository;
//
//import com.daeyeo.helloDaeyeo.entity.RefreshToken;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
//    Optional<RefreshToken> findByUserId(Long userId);
//    Optional<RefreshToken> findByRefreshToken(String refreshToken);
//}
