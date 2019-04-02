package org.wasps.data.exceptions;

public class SmellNotFoundException extends Exception {
    String smellName;

    public SmellNotFoundException(String smellName) {
        this.smellName = smellName;
    }

    public String toString() {
        return "The queried smell \"" + smellName + "\" was not found.";
    }

}
