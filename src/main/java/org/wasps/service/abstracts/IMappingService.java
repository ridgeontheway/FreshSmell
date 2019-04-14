package org.wasps.service.abstracts;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.model.ClassModel;
import org.wasps.model.ParsedClass;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMappingService {
    String mapFiles(HttpServletRequest request, MultipartFile[] inputFiles);
    List<ClassModel> mapFiles(List<ParsedClass> files);
}
