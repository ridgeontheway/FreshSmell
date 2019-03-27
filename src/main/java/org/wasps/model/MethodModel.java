package org.wasps.model;

/**
 * Implement methods from MethodModel object, but add to mapping file (if necessary)
 */

public class MethodModel {
    private String name;
    private int parameterCount;

    public MethodModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParameterCount() {
        return parameterCount;
    }

    public void setParameterCount(int parameterCount) {
        this.parameterCount = parameterCount;
    }
}
