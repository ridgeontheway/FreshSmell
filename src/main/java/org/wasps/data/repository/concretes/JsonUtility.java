package org.wasps.data.repository.concretes;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.wasps.configuration.MappingProfile;
import org.wasps.data.repository.abstracts.IJsonUtility;
import org.wasps.model.ParsedDirectory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtility implements IJsonUtility {
    protected MappingProfile _mapper;
    protected JSONSerializer _json;
    protected List<ParsedDirectory> _FileDirectories;
    protected String _directory;
    protected String _path;

    public JsonUtility() {
        _mapper = new MappingProfile();
        _json = new JSONSerializer();
        _FileDirectories = new ArrayList<>();
        _directory = System.getProperty("user.dir");
        _path = String.format("%s/src/main/java/org/wasps/data/%s%s", _directory, "data", ".json");
    }

    public void addFileToList(ParsedDirectory parsedDirectory) {
        _FileDirectories.add(parsedDirectory);
        //System.out.println("Adding " + parsedDirectory.getName() + " to List");
    }

    public List<ParsedDirectory> getFiles() {
        if (_FileDirectories.isEmpty())
            _FileDirectories = getFilesFromJson();
        return _FileDirectories;
    }

    public void writeFilesToJson() {
        try {
            FileWriter writer = new FileWriter(_path);
            _json.deepSerialize(_FileDirectories, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ParsedDirectory> getFilesFromJson() {
        ArrayList<ParsedDirectory> fileDirectories = new ArrayList<>();
        File input = new File(_path);

        if (!input.exists()) {
            writeFilesToJson();
        }

        try {
            InputStream inputStream = new FileInputStream(input);
            String fromFile = new String(inputStream.readAllBytes());
            fileDirectories = new JSONDeserializer<ArrayList<ParsedDirectory>>().deserialize(fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileDirectories;
    }

}
