package org.wasps.data.repository.abstracts;

import org.wasps.model.FileModel;

import java.util.List;

public interface IJsonUtility {
    List<FileModel> getFiles();
    void writeFiles(List<FileModel> files);
    List<FileModel> getFilesFromJson();
}
