package org.wasps.service.abstracts;

import java.io.File;

public interface ICompilerService {
    void compileUploadedFiles();
    boolean compile(File file);
//    void instantiateFiles();
}
