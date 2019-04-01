package org.wasps.model;

public class SmellReportModel {
    private String smellName;
    private float score;
    private String details;

    public String getSmellName() {
        return smellName;
    }

    public void setSmellName(String smellName) {
        this.smellName = smellName;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
