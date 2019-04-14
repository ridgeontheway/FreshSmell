package org.wasps.service.abstracts;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.model.ProjectSmellReport;
import org.wasps.viewmodel.ProjectSmellReportViewModel;

import javax.servlet.http.HttpServletRequest;

public interface IMappingService {
    String mapFiles(HttpServletRequest request, MultipartFile[] inputFiles);
    ProjectSmellReportViewModel mapToViewModel(ProjectSmellReport report);
}
