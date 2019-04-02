package org.wasps.model;

public class SmellReportModel {
    private String smellName;
    private double score;
    private String details;

    public SmellReportModel() {}

    public SmellReportModel(String smellName, double score, String details) {
        this.smellName = smellName;
        this.score = score;
        this.details = details;
    }

    public String getSmellName() {
        return smellName;
    }

    public void setSmellName(String smellName) {
        this.smellName = smellName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
