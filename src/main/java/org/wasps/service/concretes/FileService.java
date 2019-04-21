package org.wasps.service.concretes;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.wasps.data.SingletonUtility;
import org.wasps.data.utility.abstracts.IFileUtility;
import org.wasps.data.utility.abstracts.IJsonUtility;
import org.wasps.model.ClassModel;
import org.wasps.service.abstracts.IFileService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class FileService implements IFileService {
    private IFileUtility _fileUtility;
    private IJsonUtility _jsonUtility;
    private File _directory;
    private final String UPLOAD_JSON_FILE = "data.json";

    public FileService() {
        _fileUtility = SingletonUtility.getFileUtility();
        _jsonUtility = SingletonUtility.getJson();
    }

    @Override
    public String uploadAllFiles(HttpServletRequest request, MultipartFile[] files) {
        _directory = _fileUtility.getUploadDirectory(request);
        clearUploadDirectory();
        return _fileUtility.uploadAllFiles(_directory, files);
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
        return _jsonUtility.getFiles(UPLOAD_JSON_FILE);
    }

    @Override
    public void writeFilesToJson(List<ClassModel> files) {
        _jsonUtility.writeFiles(files, UPLOAD_JSON_FILE);
    }

    @Override
    public String getUploadDirectoryPath() {
        return _fileUtility.getUploadDirectoryPath();
    }

    @Override
    public void clearUploadDirectory() {
        try {
            FileUtils.cleanDirectory(_directory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}