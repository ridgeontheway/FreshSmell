package org.wasps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wasps.configuration.MappingProfile;
import org.wasps.model.SourceFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SmellController extends BaseController {
    public SmellController() {
        super(new MappingProfile());
    }

    @RequestMapping(value = "/smells", method = RequestMethod.GET)
    public List<SourceFile> getSmells() {
        List<SourceFile> smells = new ArrayList<>();

        SourceFile file1 = new SourceFile();
        file1.setName("File 1");

        SourceFile file2 = new SourceFile();
        file2.setName("File 2");

        smells.add(file1);
        smells.add(file2);

        return smells;
    }
}
