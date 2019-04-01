package org.wasps.data.repository.concretes;

import org.wasps.data.repository.SingletonUtility;
import org.wasps.data.repository.abstracts.IDataStore;

public class DataStore implements IDataStore {
    private ParsedRepository _parsed;

    public DataStore() {
        _parsed = SingletonUtility.getParsedRepository();
    }

    public ParsedRepository parsed() {
        return _parsed;
    }
}
