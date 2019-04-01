package org.wasps.service.smells.abstracts;

import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;

public interface ISmellerService {
    SmellReportModel smell(ClassModel file);
}
