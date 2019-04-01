package org.wasps.service.smells.concretes;

import org.wasps.model.FileModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;
import org.wasps.service.smells.abstracts.ISmellerService;

import java.util.ArrayList;
import java.util.List;

public class Smeller implements ISmeller {

    private List<ISmellerService> smellers;

    @Override
    public void addSmeller(ISmellerService smell) {
        smellers.add(smell);
    }

    @Override
    public List<ISmellerService> getAllSmellers() {
        return smellers;
    }

    @Override
    public List<SmellReportModel> performAllSmells(FileModel file) {
        List<SmellReportModel> smellReports = new ArrayList<>();
        smellers.forEach(smeller -> smellReports.add(smeller.smell(file)) );

        return smellReports;
    }
}
