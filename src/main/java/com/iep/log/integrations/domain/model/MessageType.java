package com.iep.log.integrations.domain.model;

public enum MessageType {

    QSO;

    public static MessageType fromString(String value) {
        return switch (value.toUpperCase()) {
            case "QSO" -> QSO;
            default -> throw new IllegalArgumentException("Unknown message type: " + value);
        };
    }

}
