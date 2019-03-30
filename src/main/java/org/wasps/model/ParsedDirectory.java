package org.wasps.model;

import org.wasps.model.fromSourceCode.ParsedClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParsedDirectory {
    private HashMap<String, ParsedClass> parsedClassHashMap;

    public ParsedDirectory() {
        parsedClassHashMap = new HashMap<>();
    }

    public void insertParsedClass(ParsedClass newClass){
        parsedClassHashMap.put(newClass.getParsedJavaClass().getSimpleName(), newClass);
    }

    public ParsedClass getParsedClass(String simpleClassName) {
        return parsedClassHashMap.get(simpleClassName);
    }

    public ArrayList<ParsedClass> getParsedClassList(){
        return new ArrayList<ParsedClass>(parsedClassHashMap.values());
    }
}
