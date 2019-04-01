package org.wasps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wasps.data.repository.SingletonUtility;
import org.wasps.model.ParsedClass;

import java.util.List;

@RestController
public class SmellController extends BaseController {
    public SmellController() {
        super(SingletonUtility.getWorker());
    }

    @RequestMapping(value = "/sourcefiles", method = RequestMethod.GET)
    public List<ParsedClass> getSourceFiles() {
        return _worker.mapper().getParsedClasses();
    }
}
