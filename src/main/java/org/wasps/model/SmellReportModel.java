package org.wasps.model;

public class SmellReportModel {
    ParsedDirectory file;
    String smellName;
    double score;

    public SmellReportModel(ParsedDirectory file, String smellName, double score) {
        this.file = file;
        this.smellName = smellName;
        this.score = score;
    }

    public ParsedDirectory getFile() {
        return file;
    }

    public String getSmellName() {
        return smellName;
    }

    public double getScore() {
        return score;
    }
}
