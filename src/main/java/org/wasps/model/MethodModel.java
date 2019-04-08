package org.wasps.model;

import com.thoughtworks.qdox.model.JavaConstructor;
import com.thoughtworks.qdox.model.JavaParameter;
import com.thoughtworks.qdox.model.JavaType;

import java.util.List;

/**
 * Implement methods from MethodModel object, but add to mapping file (if necessary)
 */

public class MethodModel {
    private String name;
    private int lineLength;
    private List<JavaParameter> parameters;
    private List<String> sourceCode;
    private JavaType returnType;
    private boolean isProtected;

    public MethodModel() {
    }

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

    public void setSorceCode(List<String> sourceCode){ this.sourceCode = sourceCode;  }

    public List<String> getSourceCode() { return this.sourceCode; }

    public void setReturnType(JavaType returnType) { this.returnType = returnType; }

    public JavaType getReturnType() { return this.returnType; }

    public boolean isProtected() { return this.isProtected; }

    public void setProtected(boolean isProtected) { this.isProtected = isProtected; }
}
