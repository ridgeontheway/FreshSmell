package org.wasps.data.repository.concretes;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.wasps.data.SingletonUtility;
import org.wasps.data.repository.abstracts.IJsonUtility;
import org.wasps.model.ClassModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtility implements IJsonUtility {
    protected JSONSerializer _json;
    protected List<ClassModel> _files;
    protected String _directory;
    protected String _path;
    protected String _jsonFile;

    public JsonUtility() {
        _json = SingletonUtility.getJsonSerializer()
                .exclude("rawConstructors", "isInterface", "isFinal", "isAbstract");
        _files = new ArrayList<>();
        _directory = System.getProperty("user.dir");
        _path = String.format("%s/src/main/java/org/wasps/data", _directory);
    }

    @Override
    public List<ClassModel> getFiles(String fileName) {
        if (_files.isEmpty())
            _files.addAll(getFilesFromJson(fileName));
        return _files;
    }

    @Override
    public void writeFiles(List<ClassModel> files, String fileName) {
        _jsonFile = String.format("%s/%s", _path, fileName);
        _files.addAll(files);
        try {
            File dir = new File(_path);
            if (!dir.exists())
                //noinspection ResultOfMethodCallIgnored
                dir.mkdirs();
            System.out.println("\nWriting to: " + _jsonFile + "\n");
            FileWriter writer = new FileWriter(_jsonFile, false);
                _json.deepSerialize(_files, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClassModel> getFilesFromJson(String fileName) {
        List<ClassModel> files = new ArrayList<>();
        File input = new File(_path);

        if (!input.exists() && !_files.isEmpty()) {
            writeFiles(_files, fileName);
        }

        try {
            InputStream inputStream = new FileInputStream(input);
            String fromFile = new String(inputStream.readAllBytes());
            files = new JSONDeserializer<ArrayList<ClassModel>>().deserialize(fromFile);
            _files.addAll(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

}
