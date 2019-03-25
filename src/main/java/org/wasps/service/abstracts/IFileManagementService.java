package org.wasps.service.abstracts;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public interface IFileManagementService {
    File createUploadDirectory(HttpServletRequest request);
    File createUploadFile(File directory, String name);
    File getUploadedFileByNameAndType(String name);
    List<File> getUploadFilesByType(String type);
    List<File> getUploadedFiles();
    File getUploadDirectory();
    File getUploadDirectory(HttpServletRequest request);
    String getUploadDirectoryPath();
}
