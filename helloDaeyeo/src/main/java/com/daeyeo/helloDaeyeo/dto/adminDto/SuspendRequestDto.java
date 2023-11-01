package com.daeyeo.helloDaeyeo.dto.adminDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuspendRequestDto {
    private String email;
    private int duration;
    private String banUnit;
}
