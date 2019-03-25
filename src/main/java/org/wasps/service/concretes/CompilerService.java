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
    public void compileUploadedFiles() {
        List<File> files = _fileManagementService.getUploadedFilesByType(".java");

        for (File file : files) {
            _compiler.run(null, null, null, file.getPath());
        }
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

    // instantiateFiles() is not working yet
//    @Override
//    public void instantiateFiles() {
//        try {
//            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{
//                    _fileManagementService.getUploadDirectory().toURI().toURL()});
//            System.out.println("\n\nOUT: ");
//            _fileManagementService.getUploadedFilesByType(".class").forEach(file -> {
//                try {
//                    Class<?> newClass = Class.forName(file.getName(), true, classLoader);
//                    System.out.println(newClass.getName());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                System.out.println("\n");
//
//            });
//
////            Class<?> newClass = Class.forName("Celsius", true, classLoader);
////            Object instance = newClass.getDeclaredConstructor().newInstance();
////            System.out.println(instance);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//

}
