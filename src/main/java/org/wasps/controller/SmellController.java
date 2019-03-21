package org.wasps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wasps.configuration.MappingProfile;
import org.wasps.data.TestClassBad;
import org.wasps.data.TestClassGood;
import org.wasps.model.SourceFile;
import org.wasps.service.concretes.Worker;

import java.util.List;

@RestController
public class SmellController extends BaseController {
    public SmellController() {
        super(new MappingProfile(), new Worker());
    }

    @RequestMapping(value = "/sourcefiles", method = RequestMethod.GET)
    public List<SourceFile> getSourceFiles() {
        List<SourceFile> sourceFiles;
        _worker.localClassLoader().loadClass(TestClassGood.class);
        _worker.localClassLoader().loadClass(TestClassBad.class);
        sourceFiles = _worker.localClassLoader().getSourceFiles();

        return sourceFiles;
    }
}
