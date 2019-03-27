package org.wasps.service.abstracts;

/*
    IWorker is the interface for controllers to access our service layer
    It provides a one-for-all way to access any utility service (non-smelling services)
 */
public interface IWorker {
    IFileService fileService();
}
