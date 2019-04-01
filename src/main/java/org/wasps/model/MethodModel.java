package org.wasps.model;

import com.thoughtworks.qdox.model.JavaParameter;

import java.util.List;

/**
 * Implement methods from MethodModel object, but add to mapping file (if necessary)
 */

public class MethodModel {
    private String name;
    private int lineLength;
    private List<JavaParameter> parameters;

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
}
