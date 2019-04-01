package org.wasps.data.repository.concretes;

import org.wasps.data.repository.abstracts.IRepository;
import org.wasps.model.ParsedClass;

public class ParsedRepository extends Repository<ParsedClass> implements IRepository<ParsedClass> {
//    private Map<String, ArrayList<ParsedClass>> map;

    public ParsedRepository() {
        super();
    }
//    public ParsedRepository() {
//        map = new HashMap<>();
//    }
//
//    public List<ParsedClass> get(String id) {
//        return map.get(id);
//    }
//
//    public List<ParsedClass> getAll() {
//        List<ParsedClass> parsedClasses = new ArrayList<>();
//        map.values().forEach(parsedClasses::addAll);
//
//        return parsedClasses;
//    }
//    
//    public void insert(ParsedClass newClass) {
//        ArrayList<ParsedClass> parsedClassList;
//        String newClassName = newClass.getParsedJavaClass().getSimpleName();
//
//        //considering the case where two classes are in different packages, but with the same name
//        if (map.containsKey(newClassName)){
//            parsedClassList = map.get(newClassName);
//            parsedClassList.add(newClass);
//            map.put(newClassName, parsedClassList);
//        }
//        else{
//            parsedClassList = new ArrayList<>();
//            parsedClassList.add(newClass);
//            map.put(newClassName, parsedClassList);
//        }
//    }
}
