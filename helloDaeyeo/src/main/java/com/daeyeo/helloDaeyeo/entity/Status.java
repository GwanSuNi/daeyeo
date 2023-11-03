package com.daeyeo.helloDaeyeo.entity;

public enum Status {
    PENDING("대기"),
    ACCEPTED("수락"),
    COMPLETED("완료"),
    CANCELED("거절"),
    HOLD("보류");
    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
