package org.wasps.data.repository.concretes;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.wasps.data.repository.SingletonUtility;
import org.wasps.data.repository.abstracts.IJsonUtility;
import org.wasps.model.FileModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtility implements IJsonUtility {
    protected JSONSerializer _json;
    protected List<FileModel> _files;
    protected String _directory;
    protected String _path;

    public JsonUtility() {
        _json = SingletonUtility.getJsonSerializer();
        _files = new ArrayList<>();
        _directory = System.getProperty("user.dir");
        _path = String.format("%s/src/main/java/org/wasps/data/%s%s", _directory, "data", ".json");
    }

    @Override
    public List<FileModel> getFiles() {
        if (_files.isEmpty())
            _files.addAll(getFilesFromJson());
        return _files;
    }

    @Override
    public void writeFiles(List<FileModel> files) {
        try {
            FileWriter writer = new FileWriter(_path);
            _json.deepSerialize(_files, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FileModel> getFilesFromJson() {
        List<FileModel> files = new ArrayList<>();
        File input = new File(_path);

        if (!input.exists() && !_files.isEmpty()) {
            writeFiles(_files);
        }

        try {
            InputStream inputStream = new FileInputStream(input);
            String fromFile = new String(inputStream.readAllBytes());
            files = new JSONDeserializer<ArrayList<FileModel>>().deserialize(fromFile);
            _files.addAll(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

}
