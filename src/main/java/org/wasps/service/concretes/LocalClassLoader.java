package org.wasps.service.concretes;

import org.wasps.WebAppInitializer;
import org.wasps.model.SourceFile;
import org.wasps.service.abstracts.IClassLoader;

import java.net.URL;

public class LocalClassLoader extends ClassLoaderBase implements IClassLoader {

    @Override
    public SourceFile loadClass(Class objectClass) {
        SourceFile sourceFile = _mapper.map(objectClass);
        addSourceFileToList(sourceFile);
        return sourceFile;
    }

    private URL localPath;

    public void setLocalPath() {
        this.localPath = WebAppInitializer.class
                .getClassLoader().getResource("uploads");
    }
}
