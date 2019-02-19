package org.wasps.controller;

import org.wasps.configuration.MappingProfile;

public class BaseController {
    protected final MappingProfile _mapper;

    public BaseController(MappingProfile mapper) {
        _mapper = mapper;
    }
}
