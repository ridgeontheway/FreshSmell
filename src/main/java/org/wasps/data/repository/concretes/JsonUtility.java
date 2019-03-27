package org.wasps.service.utilities.concretes;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.wasps.configuration.MappingProfile;
import org.wasps.model.FileModel;
import org.wasps.service.concretes.ParsingService;
import org.wasps.service.utilities.abstracts.IJsonUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtility implements IJsonUtility {
    protected MappingProfile _mapper;
    protected JSONSerializer _json;
    protected List<FileModel> _FileModels;
    protected String _directory;
    protected String _path;

    public JsonUtility() {
        _mapper = new MappingProfile(new ParsingService());
        _json = new JSONSerializer();
        _FileModels = new ArrayList<>();
        _directory = System.getProperty("user.dir");
        _path = String.format("%s/src/main/java/org/wasps/data/%s%s", _directory, "data", ".json");
    }

    public void addFileToList(FileModel fileModel) {
        _FileModels.add(fileModel);
        System.out.println("Adding " + fileModel.getName() + " to List");
    }

    public List<FileModel> getFiles() {
        if (_FileModels.isEmpty())
            _FileModels = getFilesFromJson();
        return _FileModels;
    }

    public void writeFilesToJson() {
        try {
            FileWriter writer = new FileWriter(_path);
            _json.deepSerialize(_FileModels, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<FileModel> getFilesFromJson() {
        ArrayList<FileModel> fileModels = new ArrayList<>();
        File input = new File(_path);

        if (!input.exists()) {
            writeFilesToJson();
        }

        try {
            InputStream inputStream = new FileInputStream(input);
            String fromFile = new String(inputStream.readAllBytes());
            fileModels = new JSONDeserializer<ArrayList<FileModel>>().deserialize(fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileModels;
    }

}