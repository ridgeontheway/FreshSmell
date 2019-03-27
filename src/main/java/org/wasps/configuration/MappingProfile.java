package org.wasps.configuration;

import org.wasps.model.FileModel;
import org.wasps.model.MethodModel;
import org.wasps.model.ParsedFile;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MappingProfile {

    public MappingProfile() {}

    public MethodModel mapMethod(Method methodIn) {
        MethodModel methodOut = new MethodModel();
        methodOut.setName(methodIn.getName());
        methodOut.setParameterCount(methodIn.getParameterCount());
        return methodOut;
    }

    public List<FileModel> map(List<ParsedFile> parsedFiles) {
        List<FileModel> fileModels = new ArrayList<>();
        parsedFiles.forEach(parsedFile -> {
            FileModel fileModel = new FileModel();

            // Use the parsed files like this
            fileModel.setName(parsedFile.getName());
            // All functionality for mapping for parser should go here


            // Be done by here -> we're adding the finished product
            fileModels.add(fileModel);
        });
        return fileModels;
    }

    public FileModel map(ParsedFile parsedFile) {
            FileModel fileModel = new FileModel();

            // Use the parsed files like this
            fileModel.setName(parsedFile.getName());
            // All functionality for mapping for parser should go here


            // Be done by here -> we're adding the finished product
        return fileModel;
    }

<<<<<<< HEAD
    public Iterable<MethodModel> mapMethods(Method[] methodsIn) { //todo get the line num
=======
    public List<MethodModel> mapMethods(Method[] methodsIn) {
>>>>>>> master
        ArrayList<MethodModel> methodsOut = new ArrayList<>();
        for (Method m : methodsIn) {
            methodsOut.add(mapMethod(m));
        }
        return methodsOut;
    }

}
