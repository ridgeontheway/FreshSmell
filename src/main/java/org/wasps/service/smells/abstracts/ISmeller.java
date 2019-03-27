package org.wasps.service.smells.abstracts;

import org.wasps.model.FileModel;
import org.wasps.model.SmellReportModel;

import java.util.List;

/*
    ISmeller is the interface for controllers to access our smelling service layer
    It provides a one-for-all way to access any smeller service
 */
public interface ISmeller {
    void addSmeller(ISmellerService smell);
    List<ISmellerService> getAllSmellers();
    List<SmellReportModel> performAllSmells(FileModel file);
}
