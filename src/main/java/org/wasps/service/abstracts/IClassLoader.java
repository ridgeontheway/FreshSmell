package org.wasps.service.abstracts;

import org.wasps.model.SourceFile;

import java.util.List;

public interface IClassLoader {
    SourceFile loadClass(Class objectClass);
    void addSourceFileToList(SourceFile sourceFile);
    List<SourceFile> getSourceFiles();
    void writeSourceFilesToJson();
    List<SourceFile> getSourceFilesFromJson();
}
