package org.wasps.service.concretes;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.data.repository.SingletonUtility;
import org.wasps.data.repository.abstracts.IFileUtility;
import org.wasps.data.repository.abstracts.IJsonUtility;
import org.wasps.model.ClassModel;
import org.wasps.service.abstracts.IFileService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class FileService implements IFileService {
    private IFileUtility _fileUtility;
    private IJsonUtility _jsonUtility;

    public FileService() {
        _fileUtility = SingletonUtility.getFileUtility();
        _jsonUtility = SingletonUtility.getJson();
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

    @Override
    public List<ClassModel> getFilesFromJson() {
        return _jsonUtility.getFiles();
    }

    @Override
    public void writeFilesToJson(List<ClassModel> files) {
        _jsonUtility.writeFiles(files);
    }

    @Override
    public String getUploadDirectoryPath() {
        return _fileUtility.getUploadDirectoryPath();
    }
}