package org.wasps.service.abstracts;

import org.wasps.model.fromSourceCode.abstracts.ISourceCode;

import java.io.File;
import java.util.List;

public interface ISourceCodeParserService {
    //void readDirectory(String directoryPath, File fileCallback);
    void loadInDirectory(String pathName);
    List<ISourceCode> getSourceCideFiles();

}
