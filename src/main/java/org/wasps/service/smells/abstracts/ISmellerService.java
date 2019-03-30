package org.wasps.service.smells.abstracts;

import org.wasps.model.ParsedDirectory;
import org.wasps.model.SmellReportModel;

public interface ISmellerService {
    String testFunctionality();     // Test method
    SmellReportModel smell(ParsedDirectory file);
}
