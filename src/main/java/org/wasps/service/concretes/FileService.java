package org.wasps.service.concretes;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.configuration.MappingProfile;
import org.wasps.data.repository.abstracts.IFileUtility;
import org.wasps.data.repository.abstracts.IJsonUtility;
import org.wasps.model.FileModel;
import org.wasps.model.ParsedFile;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IParsingService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileService implements IFileService {
    private IFileUtility _fileUtility;
    private IJsonUtility _jsonUtility;
    private MappingProfile _mapper;
    private IParsingService _parser;
    private List<ParsedFile> parsedFiles;
    private List<FileModel> fileModels;

    public FileService(IFileUtility fileUtility, IJsonUtility jsonUtility, IParsingService parser) {
        _fileUtility = fileUtility;
        _jsonUtility = jsonUtility;
        _parser = parser;
        parsedFiles = new ArrayList<>();
        _mapper = new MappingProfile();
    }

    @Override
    public String uploadAllFiles(HttpServletRequest request, MultipartFile[] files) {
        File directory = _fileUtility.getUploadDirectory(request);
        String message = _fileUtility.uploadAllFiles(directory, files);
        try {
            parseFiles(directory);
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Could not parse files";
        }
        try {
            mapFiles();
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Could not map files";
        }
        return message;
    }

    @Override
    public String uploadFile(HttpServletRequest request, MultipartFile file) {
        File directory = _fileUtility.getUploadDirectory(request);
        return _fileUtility.uploadFile(directory, file);
    }

    @Override
    public List<FileModel> getFiles() {
        return fileModels;
    }

    @Override
    public List<FileModel> getFilesFromJson() {
        return _jsonUtility.getFiles();
    }




    // Parse
    private void parseFiles(File directory) throws Exception {
        parsedFiles.addAll(_parser.parse(directory.listFiles()));
    }

    private void parseFile(File file) throws Exception {
        parsedFiles.add(_parser.parse(file));
    }


    // Map
    private void mapFiles() throws Exception {
        fileModels = _mapper.map(parsedFiles);
    }
}
