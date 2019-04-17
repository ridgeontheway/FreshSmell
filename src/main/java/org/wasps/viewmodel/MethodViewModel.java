package org.wasps.viewmodel;

import java.util.List;

public class MethodViewModel {
    public String name;
    public String lineLength;
    public List<String> parameters;
    public String returnType;
    public String isProtected;
    public String isAbstract;

    public MethodViewModel() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setLineLength(String lineLength) {
        this.lineLength = lineLength;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public void setIsProtected(String isProtected) {
        this.isProtected = isProtected;
    }

    public void setIsAbstract(String isAbstract) {
        this.isAbstract = isAbstract;
    }
}
