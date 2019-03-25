package org.wasps.service.concretes;

import org.wasps.service.abstracts.IClassLoader;
import org.wasps.service.abstracts.ICompilerService;
import org.wasps.service.abstracts.IFileManagementService;
import org.wasps.service.abstracts.IWorker;

public class Worker implements IWorker {
    private IClassLoader _localClassLoader;
    private IFileManagementService _fileManagementService;
    private ICompilerService _compiler;

    public Worker() {
        _localClassLoader = new LocalClassLoader();
        _fileManagementService = new FileManagementService("/uploads");
        _compiler = new CompilerService(_fileManagementService);
    }

    public IClassLoader localClassLoader() {
        return _localClassLoader;
    }

    public IFileManagementService fileManagementService() { return _fileManagementService; }

    @Override
    public ICompilerService compiler() {
        return _compiler;
    }


}
