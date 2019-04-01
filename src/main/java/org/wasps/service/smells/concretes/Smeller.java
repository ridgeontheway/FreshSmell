package org.wasps.service.smells.concretes;

import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;
import org.wasps.service.smells.abstracts.ISmellerService;

import java.util.*;

public class Smeller implements ISmeller {

    private Map<String, ISmellerService> smellers;

    public Smeller() {
        smellers = new HashMap<>();
    }

    @Override
    public void addSmeller(ISmellerService smell) {
        smellers.put(smell.getClass().getName().toLowerCase(), smell);
    }

    @Override
    public void addSmellers(List<ISmellerService> smells) {
        smells.forEach(this::addSmeller);
    }

    @Override
    public Collection<ISmellerService> getAllSmellers() {
        return smellers.values();
    }

    @Override
    public List<SmellReportModel> performAllSmells(ClassModel file) {
        List<SmellReportModel> smellReports = new ArrayList<>();
        SmellReportModel smellReport;

        for(Map.Entry<String, ISmellerService> smell : smellers.entrySet()) {
            smellReport = smell.getValue().smell(file);
            smellReports.add(smellReport);
            file.addSmellReport(smellReport);
        }
        return smellReports;
    }
}
