package org.wasps.service.concretes;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.wasps.configuration.MappingProfile;
import org.wasps.model.SourceFile;
import org.wasps.service.abstracts.IClassLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ClassLoaderBase implements IClassLoader {
    protected MappingProfile _mapper;
    protected JSONSerializer _json;
    protected List<SourceFile> _sourceFiles;
    protected String _directory;
    protected String _path;

    public ClassLoaderBase() {
        _mapper = new MappingProfile(new ParsingService());
        _json = new JSONSerializer();
        _sourceFiles = new ArrayList<>();
        _directory = System.getProperty("user.dir");
        _path = String.format("%s/src/main/java/org/wasps/data/%s%s", _directory, "data", ".json");
    }

    public void addSourceFileToList(SourceFile sourceFile) {
        _sourceFiles.add(sourceFile);
        System.out.println("Adding " + sourceFile.getName() + " to List");
    }

    public List<SourceFile> getSourceFiles() {
        if (_sourceFiles.isEmpty())
            _sourceFiles = getSourceFilesFromJson();
        return _sourceFiles;
    }

    public void writeSourceFilesToJson() {
        try {
            FileWriter writer = new FileWriter(_path);
            _json.deepSerialize(_sourceFiles, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SourceFile> getSourceFilesFromJson() {
        ArrayList<SourceFile> sourceFiles = new ArrayList<>();
        File input = new File(_path);

        if (!input.exists()) {
            writeSourceFilesToJson();
        }

        try {
            InputStream inputStream = new FileInputStream(input);
            String fromFile = new String(inputStream.readAllBytes());
            sourceFiles = new JSONDeserializer<ArrayList<SourceFile>>().deserialize(fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceFiles;
    }

}
