package org.wasps.service.concretes;

import org.wasps.data.SingletonUtility;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IMappingService;
import org.wasps.service.abstracts.IWorker;
import org.wasps.service.smells.abstracts.ISmellerService;

public class Worker implements IWorker {
    private IFileService _fileService;
    private IMappingService _mapper;
    private ISmellerService _smeller;

    public Worker() {
        _fileService = SingletonUtility.getFileService();
        _mapper = SingletonUtility.getMappingService();
        _smeller = SingletonUtility.getSmeller();
    }

    @Override
    public IMappingService mapper() {
        return _mapper;
    }

    @Override
    public IFileService fileService() { return _fileService; }

    @Override
    public ISmellerService smellerService() { return _smeller; }

}
