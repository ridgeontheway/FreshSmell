package org.wasps.model;

public class ParsedFile {
    private String name;
    private String type;
    private int lineLength;

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
}
