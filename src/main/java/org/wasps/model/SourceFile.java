package org.wasps.model;

import org.wasps.model.fromSourceCode.abstracts.ISourceCode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Implement methods from Class object, but add to mapping file
 */

public class SourceFile {
    private String name;

    // Mapping: Constructor<Constructor[] --> List<Constructor>
    private List<Constructor> constructors;
    // Mapping: Field[] --> List<Field>
    private List<Field> fields;
    // Mapping: MethodModel[] --> List<MethodModel>
    private List<MethodModel> methods;

    public SourceFile() {}

    public String getName() {
        return name;
    }

    public List<Constructor> getConstructors() {
        return constructors;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<MethodModel> getMethods() {
        return methods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void setMethods(List<MethodModel> methods) {
        this.methods = methods;
    }

    // George's source code parsing functionality
    private ISourceCode sourceCode;
}
