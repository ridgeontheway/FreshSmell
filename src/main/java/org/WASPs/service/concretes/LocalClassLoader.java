package org.wasps.service.concretes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.wasps.configuration.MappingProfile;
import org.wasps.data.TestClassGood;
import org.wasps.model.SourceFile;
import org.wasps.service.abstracts.IClassLoader;
import java.io.File;

public class LocalClassLoader extends ClassLoaderBase implements IClassLoader {

    public LocalClassLoader(MappingProfile mapper, ObjectMapper json) {
        // Configure mapping profile for SourceFile and MethodModel
        super(mapper, json);
    }

    @Override
    public SourceFile loadClass() {
        SourceFile sourceFile = _mapper.map(TestClassGood.class);
        addSourceFileToHashMap(sourceFile);
        return sourceFile;
    }

    @Override
    public void writeToJson(SourceFile sourceFile) {
        String path = String.format("%s/src/main/java/org/wasps/data/%s%s", directory, sourceFile.getName(), ".json");
        System.out.println(path);
        try {
            _json.writeValue(new File(path), sourceFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SourceFile getFromJson(String className) {
        SourceFile sourceFile = null;
        try {
            sourceFile = _json.readValue(new File(String.format("%s%s%s", directory, className, ".json")), SourceFile.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceFile;
    }
}
