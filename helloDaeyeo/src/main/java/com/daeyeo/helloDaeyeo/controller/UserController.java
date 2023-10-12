//package com.daeyeo.helloDaeyeo.controller;
//
//import com.daeyeo.helloDaeyeo.config.jwt.TokenProvider;
//import com.daeyeo.helloDaeyeo.dto.AddUserRequest;
//import com.daeyeo.helloDaeyeo.dto.CreateAccessTokenResponse;
//import com.daeyeo.helloDaeyeo.entity.RefreshToken;
//import com.daeyeo.helloDaeyeo.entity.User;
//import com.daeyeo.helloDaeyeo.service.RefreshTokenService;
//import com.daeyeo.helloDaeyeo.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.Duration;
//
//// 새로 만들어봄
//@RestController
//@RequiredArgsConstructor
//@Tag(name = "유저 컨트롤러", description = "유저 관련 API")
//public class UserController {
//    private final TokenProvider tokenProvider;
//    private final RefreshTokenService refreshTokenService;
//    private final UserService userService;
//    private final ObjectMapper objectMapper;
//
//    // TODO: 만료기간 변수화
//    // 매개변수에 원래 @RequestBody가 있었지만
//    // Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported 에러 때문에 뺌
//    @PostMapping("/user")
////    @ResponseStatus
//    @Operation(summary = "회원가입할 때 호출되는 api", description = "회원가입 시 엑세스 토큰과 리프레시 토큰이 반환됨", tags = { "jwt" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "successful operation", content = @Content()),
//            @ApiResponse(responseCode = "405", description = "Invalid input", content = @Content)
//    })
//    public ResponseEntity<CreateAccessTokenResponse> signup(@RequestBody AddUserRequest request) {
//        // 요청하는 계정으로 가입하고 성공 시 User 클래스로 반환
//        User newUser = userService.findById(userService.save(request));
//
//        // 엑세스 토큰과 리프레시 토큰 발급
//        // TODO: 토큰 만료 테스트
//        String accessToken = tokenProvider.generateToken(newUser, Duration.ofSeconds(600000));
//        // 리프레시 토큰 서버에 저장
//        RefreshToken refresh = refreshTokenService.createRefreshToken(newUser);
//
//        // 엑세스 토큰과 리프레시 토큰을 클라이언트에 반환
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new CreateAccessTokenResponse(accessToken, refresh.getRefreshToken()));
//    }
//}