package org.wasps.data.repository.abstracts;

import org.wasps.model.ClassModel;

import java.util.List;

public interface IJsonUtility {
    List<ClassModel> getFiles();
    void writeFiles(List<ClassModel> files);
    List<ClassModel> getFilesFromJson();
}
