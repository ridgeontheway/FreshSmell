package org.wasps.data.repository.concretes;

import org.wasps.data.repository.SingletonUtility;
import org.wasps.data.repository.abstracts.IDataStore;

public class DataStore implements IDataStore {
    private ModelRepository _model;
    private ParsedRepository _parsed;

    public DataStore() {
        _model = SingletonUtility.getModelRepository();
        _parsed = SingletonUtility.getParsedRepository();
    }

    @Override
    public ModelRepository model() {
        return _model;
    }

    public ParsedRepository parsed() {
        return _parsed;
    }
}
