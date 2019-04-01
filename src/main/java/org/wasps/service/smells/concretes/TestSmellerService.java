package org.wasps.service.smells.concretes;

import org.springframework.stereotype.Service;
import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmellerService;

@Service("smellerService")
public class TestSmellerService implements ISmellerService {
    @Override
    public SmellReportModel smell(ClassModel file) {
        // Smell here!
        return null;
    }
}
