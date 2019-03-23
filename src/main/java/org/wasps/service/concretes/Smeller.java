package org.wasps.service.concretes;

import org.wasps.service.abstracts.ISmeller;
import org.wasps.service.abstracts.ISmellerService;

public class Smeller implements ISmeller {

    private ISmellerService _smellerService;

    public Smeller() {
        _smellerService = new SmellerService();
    }

    public ISmellerService smellerService() {
        return _smellerService;
    }


}
