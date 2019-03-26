package org.wasps.service.abstracts;

import org.wasps.model.SourceFile;

import java.net.URL;
import java.util.List;

public interface IClassLoader {
    SourceFile loadClass(URL path);
    void addSourceFileToList(SourceFile sourceFile);
    List<SourceFile> getSourceFiles();
    void writeSourceFilesToJson();
    List<SourceFile> getSourceFilesFromJson();
}
