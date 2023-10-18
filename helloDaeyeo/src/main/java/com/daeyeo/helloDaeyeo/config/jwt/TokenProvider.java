//package com.daeyeo.helloDaeyeo.config.jwt;
//
//import com.daeyeo.helloDaeyeo.entity.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Header;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Date;
//import java.util.Set;
//
//@RequiredArgsConstructor
//@Service
//public class TokenProvider {
//    private final JwtProperties jwtProperties;
//
//    public String generateToken(User user, Duration expiredAt) {
//        Date now = new Date();
//        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), user);
//    }
//
//    // JWT 토큰 생성
//    private String makeToken(Date expiry, User user) {
//        Date now = new Date();
//
//        return Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // 헤더 타입 jwt
//                // 내용 iss : tony2yoo@gmail.com (properties 파일에서 설정한 값)
//                .setIssuer(jwtProperties.getIssuer())
//                .setIssuedAt(now) // 내용 iat : 현재 시간
//                .setExpiration(expiry) // 내용 exp : expiry 멤버 변숫값
//                .setSubject(user.getEmail()) // 내용 sub : 유저의 이메일
//                .claim("id", user.getId()) // 클레임 id : 유저 ID
//                // 서명 : 비밀값과 함께 해시값을 HS256 방식으로 암호화
//                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
//                .compact();
//    }
//
//    // JWT 토큰 유효성 검증
//    // TODO: 헤더에서 암호화 타입이 none일 때는??
//    public boolean validToken(String token) {
//        try {
//            Jwts.parser()
//                    .setSigningKey(jwtProperties.getSecretKey()) // 비밀값으로 복호화
//                    .parseClaimsJws(token);
//            return true;
//        } catch (Exception e) { // 복호화 과정에서 에러가 난다면 유효하지 않은 토큰
//            return false;
//        }
//    }
//
//    // 토큰 기반으로 인증 정보를 가져오는 메서드
//    public Authentication getAuthentication(String token) {
//        Claims claims = getClaims(token);
//        Set<SimpleGrantedAuthority> authorities = Collections.singleton(
//                new SimpleGrantedAuthority("ROLE_USER"));
//
//        return new UsernamePasswordAuthenticationToken(
//                new org.springframework.security.core.userdetails.User(
//                        claims.getSubject(), "", authorities), token, authorities);
//    }
//
//    // 토큰 기반으로 유저 ID를 가져오는 메서드
//    public Long getUserId(String token) {
//        Claims claims = getClaims(token);
//        return claims.get("id", Long.class);
//    }
//
//    private Claims getClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(jwtProperties.getSecretKey())
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}
