package org.WASPs.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Implement methods from Class object, but add to mapping file
 */

public class SourceFile {
    private String name;
    // Mapping: Constructor<Constructor[] --> Iterable<Constructor>
    private Iterable<Constructor> constructors;
    // Mapping: Field[] --> Iterable<Field>
    private Iterable<Field> fields;
    // Mapping: MethodModel[] --> Iterable<MethodModel>
    private Iterable<MethodModel> methods;

    public String getName() {
        return name;
    }

    public Iterable<Constructor> getConstructors() {
        return constructors;
    }

    public Iterable<Field> getFields() {
        return fields;
    }

    public Iterable<MethodModel> getMethods() {
        return methods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConstructors(Iterable<Constructor> constructors) {
        this.constructors = constructors;
    }

    public void setFields(Iterable<Field> fields) {
        this.fields = fields;
    }

    public void setMethods(Iterable<MethodModel> methods) {
        this.methods = methods;
    }
}
