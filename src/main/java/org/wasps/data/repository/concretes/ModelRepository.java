package org.wasps.data.repository.concretes;

import org.wasps.data.repository.abstracts.IRepository;
import org.wasps.model.ClassModel;

public class ModelRepository extends Repository<ClassModel> implements IRepository<ClassModel> {
    public ModelRepository() {
        super();
    }
}
