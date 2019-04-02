package org.wasps.service.smells.concretes;

import org.wasps.data.exceptions.SmellNotFoundException;
import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmellerService;
import org.wasps.service.smells.abstracts.ISmeller;

import java.util.*;

public class SmellerService implements ISmellerService {
    private Map<String, ISmeller> smellers;

    public SmellerService() {
        smellers = new HashMap<>();
        // Add the actual smellers
        init();
    }

    @Override
    public List<SmellReportModel> performSmells(ClassModel file) {
        List<SmellReportModel> smellReports = new ArrayList<>();
        SmellReportModel smellReport;

        for(Map.Entry<String, ISmeller> smell : smellers.entrySet()) {
            smellReport = smell.getValue().smell(file);
            smellReports.add(smellReport);
            file.addSmellReport(smellReport);
        }
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
        smellers.put("test".toLowerCase(), new TestSmeller());
        // add more...
    }
}
