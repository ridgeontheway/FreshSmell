package org.wasps.controller;

import org.wasps.service.abstracts.IWorker;

public class BaseController {
    protected final IWorker _worker;

    public BaseController(IWorker worker) {
        _worker = worker;
    }
}
