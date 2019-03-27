package org.wasps.model;

public class SmellReportModel {
    FileModel file;
    String smellName;
    double score;

    public SmellReportModel(FileModel file, String smellName, double score) {
        this.file = file;
        this.smellName = smellName;
        this.score = score;
    }

    public FileModel getFile() {
        return file;
    }

    public String getSmellName() {
        return smellName;
    }

    public double getScore() {
        return score;
    }
}
