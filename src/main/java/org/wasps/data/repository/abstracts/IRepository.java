package org.wasps.data.repository.abstracts;

import java.util.List;

public interface IRepository<T> {
    T get(String id);
    List<T> getAll();
    void insert(T t);
}
