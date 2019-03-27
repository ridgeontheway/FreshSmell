package org.wasps.service.concretes;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.data.repository.abstracts.IFileUtility;
import org.wasps.data.repository.abstracts.IJsonUtility;
import org.wasps.model.FileModel;
import org.wasps.service.abstracts.IFileService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileService implements IFileService {
    private IFileUtility _fileUtility;
    private IJsonUtility _jsonUtility;
    private List<FileModel> fileModels;

    public FileService(IFileUtility fileUtility, IJsonUtility jsonUtility) {
        _fileUtility = fileUtility;
        _jsonUtility = jsonUtility;
        fileModels = new ArrayList<>();
    }

    @Override
    public String uploadAllFiles(HttpServletRequest request, MultipartFile[] files) {
        File directory = _fileUtility.getUploadDirectory(request);
        return _fileUtility.uploadAllFiles(directory, files);
    }

    @Override
    public String uploadFile(HttpServletRequest request, MultipartFile file) {
        File directory = _fileUtility.getUploadDirectory(request);
        return _fileUtility.uploadFile(directory, file);
    }

    @Override
    public List<File> getSourceFiles() { return _fileUtility.getUploadedFiles(); }
}
