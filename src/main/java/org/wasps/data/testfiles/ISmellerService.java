package org.wasps.service.smells.abstracts;

import org.wasps.data.exceptions.SmellNotFoundException;
import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;

import java.util.List;

/*
    ISmellerService is the interface for controllers to access our smelling service layer
    It provides a one-for-all way to access any smeller service

    The actual smells themselves should be written as ISmeller classes
 */
public interface ISmellerService {
    List<SmellReportModel> performSmells(ClassModel file);
    SmellReportModel performSmell(String smellName, ClassModel file) throws SmellNotFoundException;
}
