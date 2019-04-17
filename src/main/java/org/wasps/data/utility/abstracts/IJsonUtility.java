package org.wasps.data.utility.abstracts;

import org.wasps.model.ClassModel;

import java.util.List;

public interface IJsonUtility {
    List<ClassModel> getFiles(String fileName);
    void writeFiles(List<ClassModel> files, String fileName);
    List<ClassModel> getFilesFromJson(String fileName);
}