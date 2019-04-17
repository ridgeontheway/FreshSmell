package org.wasps.data.utility.abstracts;

import org.wasps.model.ClassModel;

import java.util.List;

public interface IJsonUtility {
    void writeFiles(List<ClassModel> files, String fileName);

    List<ClassModel> getFilesFromJson(String fileName);

    List<ClassModel> getFiles();
    void writeFiles(List<ClassModel> files);
    List<ClassModel> getFilesFromJson();
}
