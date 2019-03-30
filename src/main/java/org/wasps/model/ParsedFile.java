package org.wasps.model;

import org.wasps.model.fromSourceCode.ParsedClass;

import java.util.ArrayList;

public class ParsedFile {
    private String name;
    private String type;
    private int lineLength;

    private ArrayList<ParsedClass> parsedClasses;
    //private ArrayList<ParsedInterface> parsedInterfaces;

    public ParsedFile() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    public void addParsedClass(ParsedClass parsedClass){
        parsedClasses.add(parsedClass);
    }

    //public void addParsedInterface(ParsedInterface parsedInterface){
     //   parsedInterfaces.add(parsedInterface);
    //}
}
