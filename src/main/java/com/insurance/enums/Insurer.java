package com.insurance.enums;

import java.util.HashMap;
import java.util.Map;

public enum Insurer {

    CincinnatiInsurance("Cincinnati Insurance"),
    StateFarm("State Farm"),
    Allstate("Allstate");

    private static final Map<String, Insurer> BY_INSURER = new HashMap<>();

    static {
        for (Insurer e : values()) {
            BY_INSURER.put(e.insurer, e);
        }
    }

    public String insurer;

    private Insurer(String insurer) {
        this.insurer = insurer;
    }

    public static Insurer valueOfInsurer(String insurer) {
        return BY_INSURER.get(insurer);
    }

}
