package org.wasps.service.concretes;

import org.wasps.service.abstracts.ISmellerService;
import org.springframework.stereotype.Service;

@Service("smellerService")
public class SmellerService implements ISmellerService {

    @Override
    public String testFunctionality() {
        return "Hello World";
    }
}
