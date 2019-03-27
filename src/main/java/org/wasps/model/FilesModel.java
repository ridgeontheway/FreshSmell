package org.wasps.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilesModel {
    private List<FileModel> files;

    public FilesModel() {
        files = new ArrayList<>();
    }

    public void addFile(FileModel file) {
        files.add(file);
    }

    public void addFiles(Collection<FileModel> files) { this.files.addAll(files); }

    public void removeFile(FileModel file) {
        files.remove(file);
    }

    public List<FileModel> getFiles() {
        return files;
    }

}
