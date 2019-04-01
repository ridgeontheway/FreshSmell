package org.wasps.data.repository.abstracts;

import org.wasps.data.repository.concretes.ParsedRepository;

public interface IDataStore {
    ParsedRepository parsed();
}
