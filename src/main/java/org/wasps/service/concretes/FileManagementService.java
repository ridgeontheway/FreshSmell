package org.wasps.service.concretes;

import org.wasps.service.abstracts.IFileManagementService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FileManagementService implements IFileManagementService {
    private final String UPLOAD_DIRECTORY_NAME;
    private File _directory;

    public FileManagementService(String directoryName) {
        UPLOAD_DIRECTORY_NAME = directoryName;
    }

    public File createDirectory(HttpServletRequest request) {
        String uploadPath = request.getServletContext().getRealPath(UPLOAD_DIRECTORY_NAME);
        _directory = new File(uploadPath + "/");
        //noinspection ResultOfMethodCallIgnored
        _directory.mkdirs();
        return _directory;
    }

    public File createFile(File directory, String name) {
            return new File(directory.getPath() + "/" + name);
    }

    @Override
    public File getDirectory() {
        return _directory;
    }
}
