package org.wasps.model;

import java.util.List;

/**
 * Implement methods from MethodModel object, but add to mapping file (if necessary)
 */

public class MethodModel {
    private String name;
    private int lineLength;
    private List<String> parameters;
    private List<String> sourceCode;
    private String returnType;
    private boolean isProtected;
    private boolean isAbstract;

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

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public List<String> getSourceCode() { return this.sourceCode; }

    public void setSourceCode(List<String> sourceCode){ this.sourceCode = sourceCode;  }

    public boolean isProtected() { return this.isProtected; }

    public void setProtected(boolean isProtected) { this.isProtected = isProtected; }

    public boolean isAbstract() { return this.isAbstract; }

    public void setAbstract(boolean isAbstract) { this.isAbstract = isAbstract; }

    public String getReturnType() { return this.returnType; }

    public void setReturnType(String returnType) { this.returnType = returnType; }

    @Override
    public String toString() {
        return name;
    }
}
