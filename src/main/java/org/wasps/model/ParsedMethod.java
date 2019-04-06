package org.wasps.model;

import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;
import com.thoughtworks.qdox.model.JavaType;

import java.util.List;

public class ParsedMethod {
    private String name;
    private int lineLength;
    private List<JavaParameter> parameters;
    private JavaMethod parsedMethod;
    private List<String> sourceCode;
    private JavaType returnType;

    public ParsedMethod() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    public List<JavaParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<JavaParameter> parameters) {
        this.parameters = parameters;
    }

    public JavaMethod getParsedMethod() {
        return parsedMethod;
    }

    public void setParsedMethod(JavaMethod parsedMethod) { this.parsedMethod = parsedMethod; }

    public void setSourceCode(List<String> sourceCode){this.sourceCode = sourceCode; }

    public List<String> getSourceCode(){ return this.sourceCode; }

    public void setReturnType(JavaType returnType) { this.returnType = returnType; }

    public JavaType getReturnType() { return this.returnType; }

    @Override
    public String toString() {
        return name;
    }
}
