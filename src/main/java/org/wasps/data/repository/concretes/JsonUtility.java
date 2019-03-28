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
    protected final String UPLOAD_DIRECTORY;
    protected final String UPLOAD_PATH;

    public JsonUtility() {
        _json = SingletonUtility.getJsonSerializer();
        _files = new ArrayList<>();
        UPLOAD_DIRECTORY = System.getProperty("user.dir");
        UPLOAD_PATH = String.format("%s/src/main/java/org/wasps/data/%s%s", UPLOAD_DIRECTORY, "data", ".json");
    }

    public List<FileModel> getFiles() {
        if (_files.isEmpty())
            _files = getFilesFromJson();
        return _files;
    }

    @Override
    public void writeFilesToJson(List<FileModel> files) {
        try {
            FileWriter writer = new FileWriter(UPLOAD_PATH);
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
        File input = new File(UPLOAD_PATH);

        if (!input.exists() && !_files.isEmpty()) {
            writeFilesToJson(_files);
        }

        try {
            InputStream inputStream = new FileInputStream(input);
            String fromFile = new String(inputStream.readAllBytes());
            files = new JSONDeserializer<ArrayList<FileModel>>().deserialize(fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

}
