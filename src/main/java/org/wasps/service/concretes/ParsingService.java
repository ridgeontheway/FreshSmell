package org.wasps.service.concretes;

import org.wasps.model.ParsedFile;
import org.wasps.service.abstracts.IParsingService;

import java.io.File;
import java.util.List;


public class ParsingService implements IParsingService {

    @Override
    public ParsedFile parse(File file) {
        return null;
    }

    @Override
    public List<ParsedFile> parse(File[] file) {
        return null;
    }
}
