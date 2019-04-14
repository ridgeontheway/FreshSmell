package org.wasps.controller;

import org.wasps.service.abstracts.IClassService;
import org.wasps.service.abstracts.IWorker;

public class BaseController {
    protected final IWorker _worker;
    protected final IClassService _classes;

    public BaseController(IWorker worker, IClassService classes) {
        _worker = worker;
        _classes = classes;
    }
}
