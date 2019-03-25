package org.wasps.service.abstracts;

import java.io.File;

public interface ICompilerService {
    boolean compileUploadedFiles();
    boolean compile(File file);
}
