package com.tdp.ct.web.healing.model;

import org.openqa.selenium.By;

public class CandidateElement {
    private final By locator;
    private final String strategy;
    private final int elementCount;
    private final double basePriority;
    private double score;

    public CandidateElement(By locator, String strategy, int elementCount, double basePriority) {
        this.locator = locator;
        this.strategy = strategy;
        this.elementCount = elementCount;
        this.basePriority = basePriority;
    }

    /** Compatibilidad hacia atrás */
    public CandidateElement(By locator) {
        this(locator, "unknown", 1, 0.5);
    }

    public By getLocator()          { return locator; }
    public String getStrategy()     { return strategy; }
    public int getElementCount()    { return elementCount; }
    public double getBasePriority() { return basePriority; }
    public double getScore()        { return score; }
    public void setScore(double s)  { this.score = s; }

    @Override
    public String toString() {
        return String.format("Candidate{strategy='%s', locator=%s, elements=%d, score=%.3f}",
                strategy, locator, elementCount, score);
    }
}
