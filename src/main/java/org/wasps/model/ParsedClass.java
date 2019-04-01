package org.wasps.model;

import com.thoughtworks.qdox.model.JavaClass;

import java.util.List;

public class ParsedClass {
    private String name;
    private String packageName;
    private List<String> constructors;
    private List<String> fields;
    private List<ParsedMethod> methods;
    private JavaClass parsedJavaClass;

    public ParsedClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<String> constructors) {
        this.constructors = constructors;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<ParsedMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<ParsedMethod> methods) {
        this.methods = methods;
    }

    public void setParsedJavaClass(JavaClass parsedJavaClass) {
        this.parsedJavaClass = parsedJavaClass;
    }

    public JavaClass getParsedJavaClass() {
        return parsedJavaClass;
    }

    @Override
    public String toString() {
        return name;
    }
}
