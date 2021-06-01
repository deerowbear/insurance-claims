package com.insurance.enums;

public enum ClaimState {

    VEHICLE_DAMAGE("Ready"),
    PENDING("Pending");

    private String value;

    private ClaimState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ClaimState fromValueString(String value) {
        if (value == null) {
            return null;
        }

        for (ClaimState headClaimState : ClaimState.values()) {
            if (headClaimState.value != null && headClaimState.value.equalsIgnoreCase(value)) {
                return headClaimState;
            }
        }

        return null;
    }

}
