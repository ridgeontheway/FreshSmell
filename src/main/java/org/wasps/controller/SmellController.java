package org.wasps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wasps.configuration.MappingProfile;
import org.wasps.model.ParsedDirectory;
import org.wasps.service.concretes.Worker;

import java.util.List;

@RestController
public class SmellController extends BaseController {
    public SmellController() {
        super(new MappingProfile(), new Worker());
    }

    @RequestMapping(value = "/sourcefiles", method = RequestMethod.GET)
    public ParsedDirectory getSourceFiles() {
        return _worker.fileService().getFiles();
    }
}
