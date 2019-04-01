package org.wasps.data.repository.concretes;

import org.wasps.model.fromSourceCode.ParsedClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsedRepository {
    private Map<String, ArrayList<ParsedClass>> parsedClassMap;
    public ParsedRepository() {
        parsedClassMap = new HashMap<>();
    }

    public List<ParsedClass> get(String id) {
        return parsedClassMap.get(id);
    }

    public List<ParsedClass> getAll() {
        List<ParsedClass> parsedClasses = new ArrayList<>();
        parsedClassMap.values().forEach(parsedClasses::addAll);

        return parsedClasses;
    }
    
    public void insert(ParsedClass newClass) {
        ArrayList<ParsedClass> parsedClassList;
        String newClassName = newClass.getParsedJavaClass().getSimpleName();

        //considering the case where two classes are in different packages, but with the same name
        if (parsedClassMap.containsKey(newClassName)){
            parsedClassList = parsedClassMap.get(newClassName);
            parsedClassList.add(newClass);
            parsedClassMap.put(newClassName, parsedClassList);
        }
        else{
            parsedClassList = new ArrayList<>();
            parsedClassList.add(newClass);
            parsedClassMap.put(newClassName, parsedClassList);
        }
    }
}
