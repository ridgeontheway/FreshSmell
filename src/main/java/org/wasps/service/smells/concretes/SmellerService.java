package org.wasps.service.smells.concretes;

import org.wasps.model.FileModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmellerService;
import org.springframework.stereotype.Service;

@Service("smellerService")
public class SmellerService implements ISmellerService {

    @Override
    public String testFunctionality() {
        return "Hello World";
    }

    @Override
    public SmellReportModel smell(FileModel file) {
        return null;
    }
}
