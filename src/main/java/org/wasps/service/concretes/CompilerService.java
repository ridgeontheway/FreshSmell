package org.wasps.service.concretes;

import org.wasps.service.abstracts.ICompilerService;
import org.wasps.service.abstracts.IFileManagementService;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.List;

public class CompilerService implements ICompilerService {

    private IFileManagementService _fileManagementService;
    private JavaCompiler _compiler;

    public CompilerService(IFileManagementService fileManagementService) {
        _fileManagementService = fileManagementService;
        _compiler = ToolProvider.getSystemJavaCompiler();
    }

    @Override
    public boolean compileUploadedFiles() {
        List<File> files = _fileManagementService.getUploadedFiles();

        for (File file : files) {
            try {
                _compiler.run(null, null, null, file.getPath());
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean compile(File file) {
        try {
            _compiler.run(null, null, null, file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
