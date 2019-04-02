package org.wasps.service.smells.concretes;

import org.springframework.stereotype.Service;
import org.wasps.model.ClassModel;
import org.wasps.model.SmellReportModel;
import org.wasps.service.smells.abstracts.ISmeller;

@Service("smellerService")
public class TestSmeller implements ISmeller {
    @Override
    public SmellReportModel smell(ClassModel file) {
        return smellLogic(file);
    }

    private SmellReportModel smellLogic(ClassModel file) {
        return new SmellReportModel(
                "TestSmeller",
                13.37,
                "This smell is just a test"
        );
    }
}
