package com.insurance.enums;

public enum Insurer {

    CincinnatiInsurance("Cincinnati Insurance"),
    StateFarm("State Farm"),
    Allstate("Allstate");

    private String value;

    private Insurer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Insurer fromValueString(String value) {
        if (value == null) {
            return null;
        }

        for (Insurer insurer : Insurer.values()) {
            if (insurer.value != null && insurer.value.equalsIgnoreCase(value)) {
                return insurer;
            }
        }

        return null;
    }
}
