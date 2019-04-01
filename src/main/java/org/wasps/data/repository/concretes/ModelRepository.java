package org.wasps.data.repository.concretes;

import org.wasps.data.repository.abstracts.IRepository;
import org.wasps.model.FileModel;

public class ModelRepository extends Repository<FileModel> implements IRepository<FileModel> {
//    private Map<String, ArrayList<FileModel>> map;

    public ModelRepository() {
        super();
    }


//    public ModelRepository() {
//        map = new HashMap<>();
//    }
//
//    public void insert(FileModel file) {
//        map.computeIfAbsent(file.getName(), k -> new ArrayList<>());
//        map.get(file.getName()).add(file);
//    }
//
//    public void insert(List<FileModel> files) {
//        files.forEach(this::insert);
//    }
//
//    public void delete(FileModel file) {
//        map.get(file.getName()).remove(file);
//    }
//
//    public List<FileModel> get() {
//        List<FileModel> files = new ArrayList<>();
//        map.values().forEach(files::addAll);
//
//        return files;
//    }
//
//    public List<FileModel> get(String name) {
//        return map.get(name);
//    }
//
//    public boolean isEmpty() { return map.isEmpty(); }
}
