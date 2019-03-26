package org.wasps.service.concretes;

import org.wasps.service.abstracts.IParsingService;

import java.net.URL;

public class ParsingService implements IParsingService {
    private URL sourcePath;

    @Override
    public void setInputSource(URL path) {
        sourcePath = path;
        parse();
    }

    @Override
    public String getName() {
        return "Test";
    }

    @Override
    public void parse() {

    }
}
