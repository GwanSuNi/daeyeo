package com.daeyeo.helloDaeyeo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public enum Role {
    ADMIN(0), OWNER(1), VIP_MEMBER(2), MEMBER(3);

    private final int rank;

    // static으로 선언해서 Role의 최상위 상수가 무엇인지 반환
    public static String getClosestToRank0RoleName(Set<Role> roles) {
        Role closestRole = null;
        int minRankDiff = Integer.MAX_VALUE;

        for (Role role : roles) {
            int rankDiff = Math.abs(role.getRank()); // 현재 역할의 랭크와 0과의 차이 계산
            if (rankDiff < minRankDiff) {
                minRankDiff = rankDiff;
                closestRole = role;
            }
        }

        if (closestRole != null) {
            return closestRole.name();
        }

        // roles 집합이 비어있거나 null인 경우 처리
        return null; // 또는 다른 적절한 기본값 반환
    }
}
