package com.daeyeo.helloDaeyeo.dto.adminDto;

import com.daeyeo.helloDaeyeo.entity.Role;
import com.daeyeo.helloDaeyeo.entity.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalUsersDetailDto {
    private Set<Role> roles;
    private String userEmail;
    private String nickname;
    private Status status;
    private int payment;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
