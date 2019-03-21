package org.wasps.service.abstracts;

public interface IWorker {
    IClassLoader localClassLoader();
    ISmellerService smellerService();
}
