package org.wasps.configuration;

import com.thoughtworks.qdox.model.JavaParameter;
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
        file.setRawConstructors(parsedClass.getRawConstructors());
        file.setSourceCode(trimSourceCode(parsedClass.getSourceCode()));
        file.setFinal(parsedClass.isFinal());
        file.setAbstract(parsedClass.isAbstract());
        return file;
    }

    private String trimSourceCode(String originalSourceCode) {
//        return originalSourceCode.trim().replace("\n", "")
//                                        .replace(" ", "")
//                                        .replace("\t", "");
        return originalSourceCode;
    }

    private List<String> trimSourceCode(List<String> originalSourceCode) {
        List<String> newList = new ArrayList<>();
        originalSourceCode.forEach(line -> newList.add(trimSourceCode(line)));
        return newList;
    }

    private List<MethodModel> mapMethods(List<ParsedMethod> parsedMethods) {
        List<MethodModel> methods = new ArrayList<>();
        parsedMethods.forEach(parsedMethod -> {
            MethodModel method = new MethodModel();
            method.setName(parsedMethod.getName());
            method.setLineLength(parsedMethod.getLineLength());
            method.setParameters(getParametersAsStrings(parsedMethod.getParameters()));
            method.setSourceCode(trimSourceCode(parsedMethod.getSourceCode()));
            method.setReturnType(parsedMethod.getReturnType().getValue());
            method.setProtected(parsedMethod.isProtected());
            method.setAbstract(parsedMethod.isAbstract());
            methods.add(method);
        });
        return methods;
    }

    private List<String> getParametersAsStrings(List<JavaParameter> parametersIn) {
        List<String> parametersOut = new ArrayList<>();
        parametersIn.forEach(parameter -> parametersOut.add(
                String.format("%s %s", parameter.getType().getValue(),
                                        parameter.getName())));
        return parametersOut;
    }
}
