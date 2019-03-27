package org.wasps.service.concretes;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.model.FileModel;
import org.wasps.service.abstracts.IFileService;
import org.wasps.data.repository.abstracts.IFileUtility;
import org.wasps.data.repository.abstracts.IJsonUtility;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class FileService implements IFileService {
    private IFileUtility _fileUtility;
    private IJsonUtility _jsonUtility;

    public FileService(IFileUtility fileUtility, IJsonUtility jsonUtility) {
        _fileUtility = fileUtility;
        _jsonUtility = jsonUtility;
    }


    @Override
    public String uploadAllFiles(HttpServletRequest request, MultipartFile[] files) {
        File directory = _fileUtility.createUploadDirectory(request);
        return _fileUtility.uploadAllFiles(directory, files);
    }

    @Override
    public String uploadFile(HttpServletRequest request, MultipartFile file) {
        File directory = _fileUtility.createUploadDirectory(request);
        return _fileUtility.uploadFile(directory, file);
    }

    @Override
    public List<FileModel> getFiles() {
        return _jsonUtility.getFiles();
    }
}
