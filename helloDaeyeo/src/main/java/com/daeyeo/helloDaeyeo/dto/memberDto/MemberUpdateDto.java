package com.daeyeo.helloDaeyeo.dto.memberDto;

import com.daeyeo.helloDaeyeo.embedded.Address;
import com.daeyeo.helloDaeyeo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MemberUpdateDto {
    private String userName;
    private String department;
    private Address address;
    private String phone;

    public Member memberUpdate(Member member){
        if (this.userName != "") {
            member.setUserName(this.userName);
        }
        if (this.department != "") {
            member.setDepartment(this.department);
        }
        if (this.address.getAddress() != "") {
            member.getMemberAddress().setAddress(this.address.getAddress());
        }
        if (this.address.getExtraAddress() != "") {
            member.getMemberAddress().setExtraAddress(this.address.getExtraAddress());
        }
        if (this.address.getDetailAddress() != "") {
            member.getMemberAddress().setDetailAddress(this.address.getDetailAddress());
        }
        if (this.address.getPostcode() != "") {
            member.getMemberAddress().setPostcode(this.address.getPostcode());
        }
        if (this.phone != "") {
            member.setPhone(this.phone);
        }
        return member;
    }
}
