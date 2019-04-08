package org.wasps.configuration;

import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaConstructor;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import org.apache.commons.lang3.StringUtils;
import org.wasps.model.ParsedClass;
import org.wasps.model.ParsedMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParsingProfile {

    public ParsedClass parse(JavaClass file) {
        ParsedClass parsedClass = new ParsedClass();
        parsedClass.setName(file.getSimpleName());
        parsedClass.setPackageName(file.getPackageName());
        parsedClass.setConstructors(getConstructorNames(file.getConstructors()));
        parsedClass.setFields(getFieldNames(file.getFields()));
        parsedClass.setMethods(parseMethods(file.getMethods()));
        parsedClass.setParsedJavaClass(file);
        parsedClass.setIsInterface(file.isInterface());
        parsedClass.setRawConstructors(file.getConstructors());
        parsedClass.setSourceCode(file.getSource().toString());
        parsedClass.setFinal(file.isFinal());
        parsedClass.setAbstract(file.isAbstract());
        return parsedClass;
    }

    public List<ParsedClass> parse(List<JavaClass> files) {
        List<ParsedClass> classes = new ArrayList<>();
        files.forEach(file -> classes.add(parse(file)));
        return classes;
    }

    private List<String> getConstructorNames(List<JavaConstructor> constructor) {
        List<String> names = new ArrayList<>();
        constructor.forEach(c -> names.add(c.toString()));
        return names;
    }

    private List<String> getFieldNames(List<JavaField> field) {
        List<String> names = new ArrayList<>();
        field.forEach(f -> names.add(f.toString()));
        return names;
    }

    private List<ParsedMethod> parseMethods(List<JavaMethod> files) {
        List<ParsedMethod> parsedMethods = new ArrayList<>();
        files.forEach(file -> {
            ParsedMethod method = new ParsedMethod();
            method.setName(file.getCallSignature());
            method.setLineLength(findLineLength(file));
            method.setParsedMethod(file);
            method.setParameters(file.getParameters());
            method.setSourceCode(removeWhiteSpace(file));
            method.setReturnType(file.getReturnType());
            method.setProtected(file.isProtected());
            method.setAbstract(file.isAbstract());
            parsedMethods.add(method);
        });
        return parsedMethods;
    }

    private int findLineLength(JavaMethod method) {
        return removeWhiteSpace(method).size();
    }

    private List<String> removeWhiteSpace(JavaMethod method){
        List<String> methodBody = Arrays.asList(method.getSourceCode().trim().split("\n"));
        //removing whitespace
        return  methodBody.parallelStream()
                .filter(value ->
                        !StringUtils.isBlank(value) && value.length() > 0)
                .collect(Collectors.toList());
    }
}
