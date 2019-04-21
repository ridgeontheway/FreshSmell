package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;

public abstract class SmellerBase {
    private int id;
    private String name;
    public SmellerBase(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setDetails(ClassModel model, int score, SmellReportModel report) {
        report.setDetails(model.getName() + ":\t" + score + "\t-" + report.getSmellName());
    }

    public SmellReportModel setReportModel(boolean result, ClassModel file) {
        int score = result ? 100 : 0;
        SmellReportModel tempReportModel = new SmellReportModel();
        tempReportModel.setSmellName(name);
        tempReportModel.setScore(score);
        setDetails(file, score, tempReportModel);

        return tempReportModel;
    }
}
