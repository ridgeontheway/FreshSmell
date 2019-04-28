package org.wasps.service.smells.abstracts;

import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;

public interface ISmeller {
    SmellReportModel smell(ClassModel file);
    int getId();
}
