package org.wasps.model;

import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;

import java.util.List;

public class ParsedMethod {
    private String name;
    private int lineLength;
    private List<JavaParameter> parameters;
    private JavaMethod parsedMethod;

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

    @Override
    public String toString() {
        return name;
    }
}
