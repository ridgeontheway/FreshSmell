package org.wasps.service.abstracts;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.model.FileModel;
import org.wasps.model.FilesModel;
import org.wasps.model.ParsedFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMappingService {
    String mapFiles(HttpServletRequest request, MultipartFile[] inputFiles);
    List<FileModel> mapFiles(List<ParsedFile> files);
    List<ParsedFile> getParsedFiles();
    FilesModel getFiles();
}
