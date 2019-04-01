package org.wasps.service.concretes;

import org.wasps.data.repository.abstracts.IDataStore;
import org.wasps.data.repository.concretes.DataStore;

public abstract class ServiceBase {
    public IDataStore _dataStore;

    public ServiceBase() {
        _dataStore = new DataStore();
    }
}
