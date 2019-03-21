package org.wasps.controller;

import org.wasps.configuration.MappingProfile;
import org.wasps.service.concretes.Worker;

public class BaseController {
    protected final MappingProfile _mapper;
    protected final Worker _worker;

    public BaseController(MappingProfile mapper, Worker worker) {
        _mapper = mapper;
        _worker = worker;
    }
}
