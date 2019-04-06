package org.wasps.model;

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

    public Map<String, SmellReportModel> getSmellReports() {
        return smellReports;
    }

    public void setImports(List<String> imports) { this.imports = imports; }

    public List<String> getImports() { return this.imports; }

    public void addSmellReport(SmellReportModel smellReport) {
        smellReports.put(smellReport.getSmellName(), smellReport);
    }

    public void addSmellReports(List<SmellReportModel> smellReports) {
        smellReports.forEach(smellReport ->
                this.smellReports.put(smellReport.getSmellName(), smellReport));
    }

    @Override
    public String toString() {
        return name;
    }
}
