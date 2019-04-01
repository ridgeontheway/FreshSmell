package org.wasps.service.concretes;

import org.wasps.data.repository.SingletonUtility;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IMappingService;
import org.wasps.service.abstracts.IWorker;

public class Worker implements IWorker {
    private IFileService _fileService;
    private IMappingService _mapper;

    public Worker() {
        _fileService = SingletonUtility.getFileService();
        _mapper = SingletonUtility.getMappingService();
    }

    @Override
    public IMappingService mapper() {
        return _mapper;
    }

    public IFileService fileService() { return _fileService; }

}
