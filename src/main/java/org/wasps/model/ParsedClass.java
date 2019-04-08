package org.wasps.model;

import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaConstructor;

import java.util.List;

public class ParsedClass {
    private String name;
    private String packageName;
    private List<String> constructors;
    private List<String> fields;
    private List<ParsedMethod> methods;
    private JavaClass parsedJavaClass;
    private boolean isInterface;
    private List<JavaConstructor> rawConstructors;
    private String sourceCode;
    private Boolean isFinal;

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

    public void setIsInterface(boolean isInterface) { this.isInterface = isInterface; }

    public boolean isInterface(){ return this.isInterface; }

    public void setRawConstructors(List<JavaConstructor> constructors){ this.rawConstructors = constructors; }

    public List<JavaConstructor> getRawConstructors() { return this.rawConstructors;}

    public void setSourceCode(String sourceCode){ this.sourceCode = sourceCode; }

    public String getSourceCode() { return this.sourceCode; }

    public boolean isFinal() { return this.isFinal; }

    public void setFinal(boolean isFinal) { this.isFinal = isFinal; }

    @Override
    public String toString() {
        return name;
    }
}
