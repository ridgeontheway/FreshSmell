package org.wasps.service.concretes;

import org.wasps.service.abstracts.IClassLoader;
import org.wasps.service.abstracts.IFileManagementService;
import org.wasps.service.abstracts.IWorker;

public class Worker implements IWorker {
    private IClassLoader _localClassLoader;
    private IFileManagementService _fileManagementService;

    public Worker() {
        _localClassLoader = new LocalClassLoader();
        _fileManagementService = new FileManagementService("/uploads");
    }

    public IClassLoader localClassLoader() {
        return _localClassLoader;
    }

    public IFileManagementService fileManagementService() { return _fileManagementService; }
}
