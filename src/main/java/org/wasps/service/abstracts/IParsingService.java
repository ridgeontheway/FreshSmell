package org.wasps.service.abstracts;

import org.wasps.model.ParsedFile;

import java.io.File;
import java.util.List;

public interface IParsingService {
    ParsedFile parse(File file);
    List<ParsedFile> parse(List<File> file);
}
