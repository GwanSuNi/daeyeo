package com.daeyeo.helloDaeyeo.dto.memberDto;

import com.daeyeo.helloDaeyeo.entity.Member;
import com.daeyeo.helloDaeyeo.entity.RentalObject;
import com.daeyeo.helloDaeyeo.entity.RentalStatus;
import com.daeyeo.helloDaeyeo.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberManageDto {
    private Role role;
    private String nickname;
    private String phone;
    private int statusCount;
    private int paySum;

    // 받아온 rentalObjectList 가 해당 아이디가 올린 objectList를 모두갖고옴
    public MemberManageDto(Member member, List<RentalObject> rentalObjectList) {
        this.role = member.getRoles().stream().findFirst().orElse(null);
        this.nickname = member.getNickname();
        this.phone = member.getPhone();
        for (RentalObject rentalObject : rentalObjectList) {
            for (RentalStatus rentalStatus : rentalObject.getRentalStatuses()) {
                if (rentalStatus.getMember().getUserEmail().equals(member.getUserEmail())) {
                    this.statusCount += 1;
                    if (rentalStatus.getStatus().getLabel().equals("완료") ||
                            rentalStatus.getStatus().getLabel().equals("수락")) {
                        this.paySum += rentalObject.getUsageFee();
                    }
                }
            }
        }
    }
}
