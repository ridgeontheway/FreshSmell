package org.wasps.data.utility.abstracts;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public interface IFileUtility {
    File createUploadDirectory(HttpServletRequest request);
    File createUploadFile(File directory, String name);
    String uploadFile(File directory, MultipartFile file);
    String uploadAllFiles(File directory, MultipartFile[] files);
    File getUploadedFileByNameAndType(String name);
    List<File> getUploadedFilesByType(String type);
    List<File> getUploadedFiles();
    File getUploadDirectory();
    File getUploadDirectory(HttpServletRequest request);
    String getUploadDirectoryPath();
}
