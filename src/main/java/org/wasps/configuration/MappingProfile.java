package org.wasps.configuration;

import org.wasps.model.ClassModel;
import org.wasps.model.MethodModel;
import org.wasps.model.ParsedClass;
import org.wasps.model.ParsedMethod;

import java.util.ArrayList;
import java.util.List;

public class MappingProfile {

    public List<ClassModel> map(List<ParsedClass> filesIn) {
        List<ClassModel> files = new ArrayList<>();
        filesIn.forEach(parsedClass -> files.add(map(parsedClass)));

        return files;
    }

    public ClassModel map(ParsedClass parsedClass) {
        ClassModel file = new ClassModel();
        file.setName(parsedClass.getName());
        file.setPackageName(parsedClass.getPackageName());
        file.setConstructors(parsedClass.getConstructors());
        file.setFields(parsedClass.getFields());
        file.setMethods(mapMethods(parsedClass.getMethods()));
        file.setImports(parsedClass.getParsedJavaClass().getSource().getImports());
        file.setIsInterface(parsedClass.isInterface());
        return file;
    }

    private List<MethodModel> mapMethods(List<ParsedMethod> parsedMethods) {
        List<MethodModel> methods = new ArrayList<>();
        parsedMethods.forEach(parsedMethod -> {
            MethodModel method = new MethodModel();
            method.setName(parsedMethod.getName());
            method.setLineLength(parsedMethod.getLineLength());
            method.setParameters(parsedMethod.getParameters());
            method.setSorceCode(parsedMethod.getSourceCode());
            method.setReturnType(parsedMethod.getReturnType());
            methods.add(method);
        });
        return methods;
    }
}
