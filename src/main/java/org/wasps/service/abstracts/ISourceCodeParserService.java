package org.wasps.service.abstracts;

import org.wasps.model.ParsedDirectory;
import org.wasps.model.ParsedFile;

import java.util.List;

public interface ISourceCodeParserService {
    void loadInDirectory(String pathName) throws Exception ;
    ParsedDirectory getParsedDirectory();

}
