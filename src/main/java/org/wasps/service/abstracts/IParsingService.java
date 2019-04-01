package org.wasps.service.abstracts;

import org.wasps.model.fromSourceCode.ParsedClass;

import java.util.List;

public interface IParsingService {
    List<ParsedClass> get();
    List<ParsedClass> parse(String pathName) throws Exception;
}
