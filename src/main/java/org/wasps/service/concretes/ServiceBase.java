package org.wasps.service.concretes;

import org.wasps.data.SingletonUtility;
import org.wasps.data.repository.abstracts.IDataStore;

public abstract class ServiceBase {
    protected IDataStore _dataStore;

    public ServiceBase() {
        _dataStore = SingletonUtility.getDataStore();
    }
}
