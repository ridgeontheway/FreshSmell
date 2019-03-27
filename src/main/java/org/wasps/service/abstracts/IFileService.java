package org.wasps.service.abstracts;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.model.FileModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IFileService {
    String uploadAllFiles(HttpServletRequest request, MultipartFile[] files);
    String uploadFile(HttpServletRequest request, MultipartFile file);
    List<FileModel> getFiles();
    List<FileModel> getFilesFromJson();
}
