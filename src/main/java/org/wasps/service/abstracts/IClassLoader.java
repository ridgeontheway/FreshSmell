package org.wasps.service.abstracts;

import org.wasps.model.SourceFile;

public interface IClassLoader {
    SourceFile loadClass();
    void writeToJson(SourceFile sourceFile);
    SourceFile getFromJson(String className);
}
