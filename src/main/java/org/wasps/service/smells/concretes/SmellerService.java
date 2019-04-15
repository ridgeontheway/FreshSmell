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
        init();
    }

    @Override
    public List<SmellReportModel> performSmells(ClassModel file) {
        List<ISmeller> smells = new ArrayList<>(smellers.values());
        return smells.parallelStream().map(value -> value.smell(file)).collect(Collectors.toList());
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
        smellers.put("lazyClass", new LazyClassSmell(2));
        smellers.put("inappropriateIntimacy", new InappropriateIntimacySmell(3));
        smellers.put("godComplex", new GodComplexSmell(4));
        smellers.put("featureEnvy", new FeatureEnvySmell(5));
        smellers.put("finalClassProtectedMethod", new FinalClassProtectedMethodSmell(6));
        smellers.put("abstractClassMethods", new AbstractClassMethodsSmell(7));
        smellers.put("tooManyParams", new TooManyParamsSmell(8));
        smellers.put("cyclomaticComplexity", new CyclomaticComplexitySmell(9));
        smellers.put("dataClump", new DataClumpsSmell(10));
        smellers.put("duplicateCode", new DuplicateCodeSmell(11));
        smellers.put("longMethod", new LongMethodSmell(12));

        // add more...
    }
}
