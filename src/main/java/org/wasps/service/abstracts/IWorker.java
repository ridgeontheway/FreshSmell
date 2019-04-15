package org.wasps.service.abstracts;

import org.wasps.service.smells.abstracts.IProjectSmellReportService;
import org.wasps.service.smells.abstracts.ISmellerService;

/*
    IWorker is the interface for controllers to access our service layer
    It provides a one-for-all way to access any utility service (non-smelling services)
 */
public interface IWorker {
    IMappingService mapper();
    IFileService fileService();
    ISmellerService smellerService();
    IProjectSmellReportService reportService();
    IClassService classService();
}
