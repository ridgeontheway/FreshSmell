package org.wasps.service.concretes;

import org.wasps.service.abstracts.IClassLoader;
import org.wasps.service.abstracts.ISmellerService;
import org.wasps.service.abstracts.IWorker;

/*
    Worker is the interface for controllers to access our service layer
    It provides a one-for-all way to access any service
 */
public class Worker implements IWorker {
    private IClassLoader _localClassLoader;
    private ISmellerService _smellerService;

    public Worker() {
        _localClassLoader = new LocalClassLoader();
        _smellerService = new SmellerService();
    }

    public IClassLoader localClassLoader() {
        return _localClassLoader;
    }

    public ISmellerService smellerService() {
        return _smellerService;
    }
}
