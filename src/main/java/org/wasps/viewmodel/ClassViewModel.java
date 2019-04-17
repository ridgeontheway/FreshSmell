package org.wasps.viewmodel;

import java.util.List;

public class ClassViewModel {
    public String name;
    public String packageName;
    public List<String> constructors;
    public List<String> fields;
    public List<MethodViewModel> methods;
    public List<SmellReportViewModel> smellReports;
    public List<String> imports;
    public String isInterface;
    public String isFinal;
    public String isAbstract;
    public String overallScore;
    public List<String> failureMessages;

    public ClassViewModel() {}

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setConstructors(List<String> constructors) {
        this.constructors = constructors;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public void setMethods(List<MethodViewModel> methods) {
        this.methods = methods;
    }

    public void setSmellReports(List<SmellReportViewModel> smellReports) {
        this.smellReports = smellReports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public void setIsInterface(String isInterface) {
        this.isInterface = isInterface;
    }

    public void setIsFinal(String isFinal) {
        this.isFinal = isFinal;
    }

    public void setIsAbstract(String isAbstract) {
        this.isAbstract = isAbstract;
    }

    public void setOverallScore(String overallScore) {
        this.overallScore = overallScore;
    }

    public void setFailureMessages(List<String> failureMessages) {
        this.failureMessages = failureMessages;
    }
}
