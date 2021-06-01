package com.insurance.enums;

public enum HeadClaimState {

    VEHICLE_DAMAGE("Vehicle Damage"),
    VEHICLE_RECOVERY("Vehicle Recovery"),
    STORAGE("Storage");

    private String value;

    private HeadClaimState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HeadClaimState fromValueString(String value) {
        if (value == null) {
            return null;
        }

        for (HeadClaimState headClaimState : HeadClaimState.values()) {
            if (headClaimState.value != null && headClaimState.value.equalsIgnoreCase(value)) {
                return headClaimState;
            }
        }

        return null;
    }

}
