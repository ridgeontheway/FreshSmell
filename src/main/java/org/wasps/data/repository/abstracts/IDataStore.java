package org.wasps.data.repository.abstracts;

import org.wasps.data.repository.concretes.ModelRepository;
import org.wasps.data.repository.concretes.ParsedRepository;

public interface IDataStore {
    ModelRepository model();
    ParsedRepository parsed();
}
