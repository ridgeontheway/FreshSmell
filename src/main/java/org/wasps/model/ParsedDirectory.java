package org.wasps.model;

import org.wasps.model.fromSourceCode.ParsedClass;
import java.util.ArrayList;
import java.util.HashMap;

public class ParsedDirectory {

    private HashMap<String, ArrayList<ParsedClass>> parsedClassHashMap;

    public ParsedDirectory() {
        parsedClassHashMap = new HashMap<>();
    }

    public void insertParsedClass(ParsedClass newClass){
        ArrayList<ParsedClass> parsedClassArrayList;
        String newClassName = newClass.getParsedJavaClass().getSimpleName();

        //considering the case where two classes are in different packages, but with the same name
        if (parsedClassHashMap.containsKey(newClassName)){
            parsedClassArrayList = parsedClassHashMap.get(newClassName);
            parsedClassArrayList.add(newClass);
            parsedClassHashMap.put(newClassName, parsedClassArrayList);
        }
        else{
            parsedClassArrayList = new ArrayList<>();
            parsedClassArrayList.add(newClass);
            parsedClassHashMap.put(newClassName, parsedClassArrayList);
        }
    }

    public ArrayList<ParsedClass> getParsedClass(String simpleClassName) {
        return parsedClassHashMap.get(simpleClassName);
    }

    public ArrayList<ArrayList<ParsedClass>> getParsedClassList(){
        return new ArrayList<ArrayList<ParsedClass>>(parsedClassHashMap.values());
    }
}
