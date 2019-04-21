package org.wasps.viewmodel;

import java.util.List;

public class ProjectSmellReportViewModel {
    public String finalScore;
    public List<ClassViewModel> classes;
    public String reportMessages;

    public ProjectSmellReportViewModel() {}

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    public List<ClassViewModel> getClasses() { return classes; }

    public void setClasses(List<ClassViewModel> classes) {
        this.classes = classes;
    }

    public String getReportMessages() { return reportMessages; }

    public void setReportMessages(String reportMessages) {
        this.reportMessages = reportMessages;
    }

}
