package com.daeyeo.helloDaeyeo.dto.memberRegistDto;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterDto {
    @NotEmpty(message = "이메일을 입력하세요")
    @Email(message = "이메일 형식에 맞게 다시 입력하세요")
    private String userEmail;
    @NotEmpty(message = "비밀번호를 입력하세요")
    @Size(min = 4, max = 20)
    private String userPw;
    @NotEmpty(message = "비밀번호 확인 칸에 비밀번호를 입력하세요")
    private String userPw1;
    @NotEmpty(message = "이름을 입력하세요")
    private String userName;
    private LocalDateTime registDate;
    @Valid
    private Address address;
    @NotEmpty(message = "핸드폰 번호를 입력하세요")
    @Pattern(regexp = "^(01[016789])-\\d{3,4}-\\d{4}$", message = "올바른 핸드폰 번호를 입력하세요")
    private String phone;
    @NotEmpty(message = "부서를 올바르게 입력하세요")
    private String department;
    private Set<Role> roles;

    public MemberRegisterDto(String userName , String userEmail , String userPw ,
                             Address address , String phone , String department){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPw = userPw;
        this.address = address;
        this.phone = phone;
        this.department = department;
        this.registDate = LocalDateTime.now();
    }
}
