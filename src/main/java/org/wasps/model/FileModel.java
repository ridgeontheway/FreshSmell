package org.wasps.model;

import java.util.List;

public class FileModel {
    private String name;
    private String packageName;
    private List<String> constructors;
    private List<String> fields;
    private List<MethodModel> methods;

    public FileModel() { }

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

    public List<MethodModel> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodModel> methods) {
        this.methods = methods;
    }

    @Override
    public String toString() {
        return name;
    }
}
