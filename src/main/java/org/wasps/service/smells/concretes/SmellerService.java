package org.wasps.service.smells.concretes;

import org.wasps.data.exceptions.SmellNotFoundException;
import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;
import org.wasps.service.smells.abstracts.ISmellerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmellerService implements ISmellerService {
    private final int PASS_THRESHOLD = 50;
    private final Map<String, ISmeller> smellers;

    public SmellerService() {
        smellers = new HashMap<>();
        init();
    }

    @Override
    public List<SmellReportModel> performSmells(ClassModel file) {
        List<ISmeller> smells = new ArrayList<>(smellers.values());
        List<SmellReportModel> reports = new ArrayList<>();

        double numberOfPasses = 0;
        for (ISmeller smell : smells) {
            SmellReportModel report = smell.smell(file);
            if (report.getScore() >= PASS_THRESHOLD) {
                numberOfPasses++;
            }
            else {
                file.getFailureMessages().add(report.getDetails());
            }
            reports.add(report);
        }
        file.setOverallScore(numberOfPasses / ((double) smells.size()));
        
        return reports;
    }

    @Override
    public SmellReportModel performSmell(String smellName, ClassModel file) throws SmellNotFoundException {
        if (!smellers.containsKey(smellName))
            throw new SmellNotFoundException(smellName);

        return smellers.get(smellName.toLowerCase()).smell(file);
    }

    // Instantiate all new smellers here directly to the map
    private void init() {
        smellers.put("lazyClass", new LazyClassSmell(1));
        smellers.put("inappropriateIntimacy", new InappropriateIntimacySmell(2));
        smellers.put("godComplex", new GodComplexSmell(3));
        smellers.put("featureEnvy", new FeatureEnvySmell(4));
        smellers.put("finalClassProtectedMethod", new FinalClassProtectedMethodSmell(5));
        smellers.put("abstractClassMethods", new AbstractClassMethodsSmell(6));
        // add more...
    }
}
