package org.wasps.data.repository.concretes;

import org.wasps.data.repository.abstracts.IRepository;
import org.wasps.model.ClassModel;

public class ModelRepository extends Repository<ClassModel> implements IRepository<ClassModel> {
//    private Map<String, ArrayList<ClassModel>> map;

    public ModelRepository() {
        super();
    }


//    public ModelRepository() {
//        map = new HashMap<>();
//    }
//
//    public void insert(ClassModel file) {
//        map.computeIfAbsent(file.getName(), k -> new ArrayList<>());
//        map.get(file.getName()).add(file);
//    }
//
//    public void insert(List<ClassModel> files) {
//        files.forEach(this::insert);
//    }
//
//    public void delete(ClassModel file) {
//        map.get(file.getName()).remove(file);
//    }
//
//    public List<ClassModel> get() {
//        List<ClassModel> files = new ArrayList<>();
//        map.values().forEach(files::addAll);
//
//        return files;
//    }
//
//    public List<ClassModel> get(String name) {
//        return map.get(name);
//    }
//
//    public boolean isEmpty() { return map.isEmpty(); }
}
