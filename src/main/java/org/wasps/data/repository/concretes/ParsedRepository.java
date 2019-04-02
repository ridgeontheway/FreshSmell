package org.wasps.data.repository.concretes;

import org.wasps.data.repository.abstracts.IRepository;
import org.wasps.model.ParsedClass;

public class ParsedRepository extends Repository<ParsedClass> implements IRepository<ParsedClass> {
    public ParsedRepository() {
        super();
    }
}
