package org.wasps.model;

import java.util.List;

public class ProjectSmellReport {
    private double finalScore;
    private List<ClassModel> classes;
    List<String> reportMessages;

    public ProjectSmellReport() {}

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public List<ClassModel> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassModel> classes) {
        this.classes = classes;
    }

    public List<String> getReportMessages() {
        return reportMessages;
    }

    public void setReportMessages(List<String> reportMessages) {
        this.reportMessages = reportMessages;
    }
}
