package org.wasps.service.concretes;

import org.wasps.data.SingletonUtility;
import org.wasps.service.abstracts.IClassService;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IMappingService;
import org.wasps.service.abstracts.IWorker;
import org.wasps.service.smells.abstracts.IProjectSmellReportService;
import org.wasps.service.smells.abstracts.ISmellerService;

public class Worker implements IWorker {
    private IFileService _fileService;
    private IMappingService _mapper;
    private ISmellerService _smeller;
    private IProjectSmellReportService _reportService;
    protected final IClassService _classService;


    public Worker() {
        _fileService = SingletonUtility.getFileService();
        _mapper = SingletonUtility.getMappingService();
        _smeller = SingletonUtility.getSmeller();
        _reportService = SingletonUtility.getReportService();
        _classService = SingletonUtility.getClassService();
    }

    @Override
    public IMappingService mapper() {
        return _mapper;
    }

    @Override
    public IFileService fileService() { return _fileService; }

    @Override
    public ISmellerService smellerService() { return _smeller; }

    @Override
    public IProjectSmellReportService reportService() { return _reportService; }

    @Override
    public IClassService classService() {
        return _classService;
    }

}
