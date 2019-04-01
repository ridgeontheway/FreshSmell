package org.wasps.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilesModel {
    private List<FileModel> files;

    public FilesModel() {
        files = new ArrayList<>();
    }

    public void insert(FileModel file) {
        files.add(file);
    }

    public void insert(Collection<FileModel> files) { this.files.addAll(files); }

    public void delete(FileModel file) {
        files.remove(file);
    }

    public List<FileModel> get() {
        return files;
    }

    public boolean isEmpty() { return files.isEmpty(); }
}
