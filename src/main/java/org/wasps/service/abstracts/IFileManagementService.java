package org.wasps.service.abstracts;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public interface IFileManagementService {
    File createUploadsDirectory(HttpServletRequest request);
    File createUploadFile(File directory, String name);
    File getUploadedFileByNameAndType(String name);
    List<File> getUploadFilesByType(String type);
    List<File> getUploadFiles();
    File getUploadDirectory();
    String getUploadDirectoryPath();
}
