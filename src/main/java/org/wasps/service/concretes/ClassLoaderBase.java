package org.wasps.service.concretes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.wasps.configuration.MappingProfile;
import org.wasps.model.SourceFile;

import java.util.HashMap;

public abstract class ClassLoaderBase {
    protected MappingProfile _mapper;
    protected ObjectMapper _json;
    protected HashMap<String, SourceFile> _sourceFiles;
    protected String directory = System.getProperty("user.dir");

    public ClassLoaderBase(MappingProfile mapper, ObjectMapper json) {
        _mapper = mapper;
        _json = json;
        _sourceFiles = new HashMap<>();
    }

    public void addSourceFileToHashMap(SourceFile sourceFile) {
        _sourceFiles.put(sourceFile.getName(), sourceFile);
    }

    public HashMap getSourceFiles() {
        return _sourceFiles;
    }

}
