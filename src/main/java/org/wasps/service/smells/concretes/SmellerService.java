package org.wasps.service.smells.concretes;

import org.wasps.data.exceptions.SmellNotFoundException;
import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmellerService;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.*;
import java.util.stream.Collectors;

public class SmellerService implements ISmellerService {
    private Map<String, ISmeller> smellers;

    public SmellerService() {
        smellers = new HashMap<>();
        // Add the actual smellers
        init();
    }

    @Override
    public List<SmellReportModel> performSmells(ClassModel file) {
        List<ISmeller> smells = (List<ISmeller>) smellers.values();
        List<SmellReportModel> smellReports = smells.parallelStream().map(value -> value.smell(file)).collect(Collectors.toList());
        return smellReports;
    }

    @Override
    public SmellReportModel performSmell(String smellName, ClassModel file) throws SmellNotFoundException {
        if (!smellers.containsKey(smellName))
            throw new SmellNotFoundException(smellName);

        return smellers.get(smellName.toLowerCase()).smell(file);
    }

    // Instantiate all new smellers here directly to the map
    private void init() {
        smellers.put("test", new TestSmeller());
        smellers.put("lazyClass", new LazyClassSmell());
        smellers.put("inappropriateIntimacy", new InappropriateIntimacySmell());
        smellers.put("godComplex", new GodComplexSmell());
        smellers.put("featureEnvy", new FeatureEnvySmell());
        smellers.put("finalClassProtectedMethod", new FinalClassProtectedMethodSmell());
        // add more...
    }
}
