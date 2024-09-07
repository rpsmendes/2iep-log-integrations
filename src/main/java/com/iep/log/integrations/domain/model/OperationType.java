package com.iep.log.integrations.domain.model;

public enum OperationType {

    UPDATE, DELETE, CREATE;

    public static OperationType fromString(String value) {
        return switch (value.toUpperCase()) {
            case "UPDATE" -> UPDATE;
            case "DELETE" -> DELETE;
            case "CREATE" -> CREATE;
            default -> throw new IllegalArgumentException("Unknown operation type: " + value);
        };
    }

}
