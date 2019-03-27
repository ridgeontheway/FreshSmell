package org.wasps.service.concretes;

import org.wasps.model.ParsedFile;
import org.wasps.service.abstracts.IParsingService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ParsingService implements IParsingService {

    @Override
    public ParsedFile parse(File file) {
        ParsedFile parsedFile = new ParsedFile();

        return parsedFile;
    }

    @Override
    public List<ParsedFile> parse(File[] file) {
        List<ParsedFile> parsedFiles = new ArrayList<>();

        return parsedFiles;
    }
}
