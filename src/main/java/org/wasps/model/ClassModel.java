package org.wasps.model;

import com.thoughtworks.qdox.model.JavaConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassModel {
    private String name;
    private String packageName;
    private List<String> constructors;
    private List<String> fields;
    private List<MethodModel> methods;
    private Map<String, SmellReportModel> smellReports;
    private List<String> imports;
    private boolean isInterface;
    private List<JavaConstructor> rawConstructors;          // Not serialized
    private String sourceCode;
    private boolean isFinal;
    private boolean isAbstract;
    private double overallScore;
    private List<String> failureMessages;

    public ClassModel() {
        smellReports = new HashMap<>();
        failureMessages = new ArrayList<>();
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

    public List<MethodModel> getMethods() {
        return methods;
    }

    public void setMethods(List<MethodModel> methods) {
        this.methods = methods;
    }

    public List<String> getImports() { return this.imports; }

    public void setImports(List<String> imports) { this.imports = imports; }

    public Map<String, SmellReportModel> getSmellReports() { return this.smellReports; }

    public void addSmellReport(SmellReportModel smellReport) {
        smellReports.put(smellReport.getSmellName(), smellReport);
    }

    public void addSmellReports(List<SmellReportModel> smellReports) {
        smellReports.forEach(smellReport ->
                this.smellReports.put(smellReport.getSmellName(), smellReport));
    }

    public void setSmellReports(Map<String, SmellReportModel> smellReports) {
        this.smellReports = smellReports;
    }

    public boolean isInterface(){ return this.isInterface; }

    public void setIsInterface(boolean isInterface) { this.isInterface = isInterface; }

    public List<JavaConstructor> getRawConstructors() { return this.rawConstructors; }

    public void setRawConstructors(List<JavaConstructor> constructors) { this.rawConstructors = constructors; }

    public String getSourceCode() { return this.sourceCode; }

    public void setSourceCode(String sourceCode){ this.sourceCode = sourceCode; }

    public boolean isFinal() { return this.isFinal;}

    public void setFinal(boolean isFinal) { this.isFinal = isFinal; }

    public boolean isAbstract() { return this.isAbstract; }

    public void setAbstract(boolean isAbstract) { this.isAbstract = isAbstract; }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public void setFailureMessages(List<String> failureMessages) {
        this.failureMessages = failureMessages;
    }

    @Override
    public String toString() {
        return name;
    }
}
