package org.wasps.service.concretes;

import org.wasps.model.fromSourceCode.abstracts.ISourceCode;
import org.wasps.service.abstracts.ISourceCodeParserService;

import java.util.List;

public class ParserService implements ISourceCodeParserService {

    @Override
    public void loadInDirectory(String pathName) {

    }

    @Override
    public List<ISourceCode> getSourceCodeFiles() {
        return null;
    }
}
