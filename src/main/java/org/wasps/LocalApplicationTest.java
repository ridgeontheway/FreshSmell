package org.wasps;

import org.wasps.model.MethodModel;
import org.wasps.model.SourceFile;
import org.wasps.service.concretes.LocalClassLoader;

import java.util.ArrayList;
import java.util.List;

// This class is to test any functionality locally
// This should be run as a separate, regular Application run configuration
public class LocalApplicationTest {
    public static void main(String[] args) {
        LocalClassLoader loader = new LocalClassLoader();

        loader.writeSourceFilesToJson();
        List<SourceFile> fromJson = loader.getSourceFilesFromJson();
        List<List<MethodModel>> methods = new ArrayList<>();
        fromJson.forEach(file -> methods.add(file.getMethods()));
        methods.get(0).forEach(method -> System.out.println(method.getName()));
    }
}
