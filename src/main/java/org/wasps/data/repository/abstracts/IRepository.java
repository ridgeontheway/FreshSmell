package org.wasps.data.repository.abstracts;

import java.util.List;

public interface IRepository<T> {
    List<T> get(String id);
    List<T> get();
    void insert(T t);
    void insert(List<T> t);
    void delete(T t);
    boolean isEmpty();
}
