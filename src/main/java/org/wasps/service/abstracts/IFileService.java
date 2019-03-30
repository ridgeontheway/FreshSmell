package org.wasps.service.abstracts;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.model.ParsedDirectory;
import org.wasps.model.fromSourceCode.ParsedClass;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IFileService {
    String uploadAllFiles(HttpServletRequest request, MultipartFile[] files);
    String uploadFile(HttpServletRequest request, MultipartFile file);
    ParsedDirectory getFiles();
    List<ParsedDirectory> getFilesFromJson();
}
