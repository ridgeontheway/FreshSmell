package org.wasps.service.concretes;

import org.wasps.service.abstracts.IFileManagementService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileManagementService implements IFileManagementService {
    private final String UPLOAD_DIRECTORY_NAME;
    private String UPLOAD_DIRECTORY_PATH;
    private File _uploadDirectory;

    public FileManagementService(String directoryName) {
        UPLOAD_DIRECTORY_NAME = directoryName;
    }

    public File createUploadsDirectory(HttpServletRequest request) {
        String uploadPath = request.getServletContext().getRealPath(UPLOAD_DIRECTORY_NAME);
        UPLOAD_DIRECTORY_PATH = uploadPath + "/";
        _uploadDirectory = new File(UPLOAD_DIRECTORY_PATH);
        if (!_uploadDirectory.exists())
            //noinspection ResultOfMethodCallIgnored
            _uploadDirectory.mkdirs();
        return _uploadDirectory;
    }

    public File createUploadFile(File directory, String name) {
        return new File(directory.getPath() + "/" + name);
    }

    @Override
    public File getUploadedFileByNameAndType(String queryName) {
        File files[] = _uploadDirectory.listFiles((dir, name) -> name.equalsIgnoreCase(queryName));

        if (files == null)
            return null;

        return files[0];
    }

    @Override
    public List<File> getUploadFilesByType(String queryType) {
        File files[] = _uploadDirectory.listFiles((dir, name) -> name.endsWith(queryType));

        if (files == null)
            return null;

        return Arrays.asList(files);
    }

    @Override
    public List<File> getUploadFiles() {
        File files[] = _uploadDirectory.listFiles();

        if (files == null)
            return null;

        return Arrays.asList(files);
    }

    @Override
    public File getUploadDirectory() {
        return _uploadDirectory;
    }

    @Override
    public String getUploadDirectoryPath() { return UPLOAD_DIRECTORY_PATH; }
}
