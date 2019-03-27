package org.wasps.service.concretes;

import org.wasps.service.abstracts.ICompilerService;
import org.wasps.data.repository.abstracts.IFileUtility;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.List;

public class CompilerService implements ICompilerService {

    private IFileUtility _fileManagementService;
    private JavaCompiler _compiler;

    public CompilerService(IFileUtility fileManagementService) {
        _fileManagementService = fileManagementService;
        _compiler = ToolProvider.getSystemJavaCompiler();
    }

    @Override
    public void compileUploadedFiles() {
        List<File> files = _fileManagementService.getUploadedFilesByType(".java");

        files.forEach(System.out::println);

        for (File file : files) {
            _compiler.run(null, null, null, file.getPath());
        }
    }
}
