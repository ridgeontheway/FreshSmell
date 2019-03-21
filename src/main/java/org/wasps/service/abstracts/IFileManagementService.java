package org.wasps.service.abstracts;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public interface IFileManagementService {
    File createDirectory(HttpServletRequest request);
    File createFile(File directory, String name);
    File getDirectory();
}
