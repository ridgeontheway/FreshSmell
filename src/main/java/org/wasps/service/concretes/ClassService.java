package org.wasps.service.concretes;

import org.wasps.model.ClassModel;
import org.wasps.service.abstracts.IClassService;

import java.util.List;

public class ClassService extends ServiceBase implements IClassService {
    @Override
    public List<ClassModel> get() {
        return _dataStore.model().get();
    }

    @Override
    public List<ClassModel> get(String id) {
        return _dataStore.model().get(id);
    }

    @Override
    public void insert(List<ClassModel> classModels) {
        _dataStore.model().insert(classModels);
    }
}