package com.insurance.enums;

import java.util.HashMap;
import java.util.Map;

public enum InsuranceState {


    VehicleDamage(1),
    StateFarm(2),
    Allstate(3);

    private static final Map<Long, InsuranceState> BY_STATE = new HashMap<>();

    static {
        for (InsuranceState e : values()) {
            BY_STATE.put(e.state, e);
        }
    }

    public long state = 0;

    private InsuranceState(long state) {
        this.state = state;
    }

    public static InsuranceState valueOfInsurer(long state) {
        return BY_STATE.get(BY_STATE);
    }

}
