package org.wasps.service.smells.abstracts;

import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;

import java.util.Collection;
import java.util.List;

/*
    ISmeller is the interface for controllers to access our smelling service layer
    It provides a one-for-all way to access any smeller service

    The actual smells themselves should be written as ISmellerService classes
 */
public interface ISmeller {
    void addSmeller(ISmellerService smell);

    void addSmellers(List<ISmellerService> smells);

    Collection<ISmellerService> getAllSmellers();

    List<SmellReportModel> performAllSmells(ClassModel file);
}
