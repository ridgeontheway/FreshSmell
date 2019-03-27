package org.wasps.service.utilities.abstracts;

import org.wasps.model.FileModel;

import java.util.List;

public interface IJsonUtility {
    void addFileToList(FileModel fileModel);
    List<FileModel> getFiles();
    void writeFilesToJson();
    List<FileModel> getFilesFromJson();
}
