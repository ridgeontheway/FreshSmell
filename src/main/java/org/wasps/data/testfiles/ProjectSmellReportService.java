package org.wasps.service.smells.concretes;

import org.wasps.data.SingletonUtility;
import org.wasps.model.ClassModel;
import org.wasps.model.ProjectSmellReport;
import org.wasps.service.concretes.ServiceBase;
import org.wasps.service.smells.abstracts.IProjectSmellReportService;
import org.wasps.service.smells.abstracts.ISmellerService;

import java.util.ArrayList;
import java.util.List;

public class ProjectSmellReportService extends ServiceBase implements IProjectSmellReportService {
    private ProjectSmellReport report;
    private ISmellerService smeller;

    public ProjectSmellReportService() {
        report = new ProjectSmellReport();
        report.setClasses(_dataStore.model().get());
        smeller = SingletonUtility.getSmeller();
    }

    @Override
    public ProjectSmellReport generateProjectSmellReport() {
        List<ClassModel> classes = _dataStore.model().get();
        classes.parallelStream().forEach(model -> model.addSmellReports(smeller.performSmells(model)));

        ProjectSmellReport report = new ProjectSmellReport();
        report.setClasses(classes);

        List<String> messages = new ArrayList<>();
        classes.forEach(model -> messages.addAll(model.getFailureMessages()));

        double overallScore = 0.0;
        for (ClassModel model : classes) {
            overallScore += model.getOverallScore();
        }
        // Final score is the average overall score of all classes rounded to two decimal places
        overallScore = Math.round((overallScore / ((double) classes.size())) * 100) / 100;
        report.setFinalScore(overallScore);

        return report;
    }
}
