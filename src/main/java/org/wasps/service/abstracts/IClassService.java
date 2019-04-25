package org.wasps.service.abstracts;

import org.wasps.model.ClassModel;

import java.util.List;

public interface IClassService {
    List<ClassModel> get();
    List<ClassModel> get(String id);
    void insert(List<ClassModel> classModels);
    void delete();
}
