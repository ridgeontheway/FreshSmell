package org.wasps.model;

import com.thoughtworks.qdox.model.JavaConstructor;

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

    public ClassModel() {
        smellReports = new HashMap<>();
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

    public void setImports(List<String> imports) { this.imports = imports; }

    public List<String> getImports() { return this.imports; }

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

    public void setIsInterface(boolean isInterface) { this.isInterface = isInterface; }

    public boolean isInterface(){ return this.isInterface; }

    public List<JavaConstructor> getRawConstructors() { return this.rawConstructors; }

    public void setRawConstructors(List<JavaConstructor> constructors) { this.rawConstructors = constructors; }

    public void setSourceCode(String sourceCode){ this.sourceCode = sourceCode; }

    public String getSourceCode() { return this.sourceCode; }

    @Override
    public String toString() {
        return name;
    }
}
