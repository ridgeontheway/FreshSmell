package org.wasps.service.smells.abstracts;

import org.wasps.model.FileModel;
import org.wasps.model.SmellReportModel;

public interface ISmellerService {
    String testFunctionality();     // Test method
    SmellReportModel smell(FileModel file);
}
