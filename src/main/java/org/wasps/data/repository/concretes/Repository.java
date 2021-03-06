package org.wasps.data.repository.concretes;

import org.wasps.data.repository.abstracts.IRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Repository<T> implements IRepository<T> {
    private Map<String, ArrayList<T>> map;

    public Repository() {
        map = new HashMap<>();
    }

    public void insert(T file) {
        map.computeIfAbsent(file.toString(), k -> new ArrayList<>());
        map.get(file.toString()).add(file);
    }

    public void insert(List<T> files) {
        files.forEach(this::insert);
    }

    public void delete(T file) {
        map.get(file.toString()).remove(file);
    }

    public void delete() { map.clear(); }

    public List<T> get() {
        List<T> files = new ArrayList<>();
        map.values().forEach(files::addAll);
        return files;
    }

    public List<T> get(String name) {
        return map.get(name);
    }

    public boolean isEmpty() { return map.isEmpty(); }
}
