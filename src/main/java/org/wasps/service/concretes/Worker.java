package org.wasps.service.concretes;

import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IWorker;
import org.wasps.data.repository.concretes.FileUtility;
import org.wasps.data.repository.concretes.JsonUtility;

public class Worker implements IWorker {
    private IFileService _fileService;

    public Worker() {
        _fileService = new FileService(new FileUtility("/uploads"),
                                        new JsonUtility(),
                                        new ParsingService());
    }

    public IFileService fileService() { return _fileService; }

}
