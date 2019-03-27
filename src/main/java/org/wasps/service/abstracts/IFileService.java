package org.wasps.service.abstracts;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public interface IFileService {
    String uploadAllFiles(HttpServletRequest request, MultipartFile[] files);
    String uploadFile(HttpServletRequest request, MultipartFile file);
    List<File> getSourceFiles();
}
