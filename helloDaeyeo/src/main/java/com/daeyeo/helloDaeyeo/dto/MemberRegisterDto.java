package com.daeyeo.helloDaeyeo.dto;

import com.daeyeo.helloDaeyeo.embedded.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.stream.XMLEventWriter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRegisterDto {
    @NotNull(message = "이메일을 입력하세요")
    @Email(message = "이메일 형식에 맞게 다시 입력하세요")
    private String userEmail;
    @NotNull(message = "비밀번호를 입력하세요")
    private String userPw;
    @NotNull(message = "이름을 입력하세요")
    private String userName;
    private LocalDateTime registDate;
    @NotNull(message = "주소를 입력하세요")
    private Address address;
    @NotNull
    @Pattern(regexp = "^(01[016789])-\\d{3,4}-\\d{4}$", message = "올바른 핸드폰 번호를 입력하세요")
    private String phone;
    @NotNull(message = "부서를 올바르게 입력하세요")
    private String department;

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
