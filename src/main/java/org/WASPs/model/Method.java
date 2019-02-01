package org.WASPs.model;

/**
 * Implement methods from Method object, but add to mapping file (if necessary)
 */

public class Method {
    private String name;
    private int parameterCount;

    public String getName() {
        return name;
    }

    public int getParameterCount() {
        return parameterCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParameterCount(int parameterCount) {
        this.parameterCount = parameterCount;
    }
}
