package org.wasps.service.concretes;

import org.wasps.model.SourceFile;
import org.wasps.service.abstracts.IClassLoader;

import java.net.URL;

public class LocalClassLoader extends ClassLoaderBase implements IClassLoader {

    @Override
    public SourceFile loadClass(URL path) {
        SourceFile sourceFile = _mapper.map(path);
        addSourceFileToList(sourceFile);
        return sourceFile;
    }
}
