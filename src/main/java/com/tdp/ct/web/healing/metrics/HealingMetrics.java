package com.tdp.ct.web.healing.metrics;

public class HealingMetrics {
    private int detected;
    private int repaired;

    public void add(boolean successful) {
        detected++;
        if (successful) {
            repaired++;
        }
    }

    public int getDetected() {
        return detected;
    }

    public int getRepaired() {
        return repaired;
    }

    public double getAHSR() {
        return detected == 0 ? 0 : repaired * 100.0 / detected;
    }
}
