package org.wasps.service.concretes;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.configuration.MappingProfile;
import org.wasps.data.repository.SingletonUtility;
import org.wasps.model.ClassModel;
import org.wasps.model.ParsedClass;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IMappingService;
import org.wasps.service.abstracts.IParsingService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class MappingService implements IMappingService {
    private final MappingProfile _profile;
    private final IFileService _fileService;
    private final IParsingService _parser;
    private List<ParsedClass> parsedClasses;
    private List<ClassModel> files;

    public MappingService() {
        _profile = SingletonUtility.getMappingProfile();
        _fileService = SingletonUtility.getFileService();
        _parser = SingletonUtility.getParser();
        files = new ArrayList<>();
        parsedClasses = new ArrayList<>();
    }

    /*
    This method is the primary controller of our pipeline for ".java -> ClassModel"
    1. Upload files to working directory
    2. Parse those files into ParedFile models
    3. Map the files from ParsedFile -> ClassModel as defined in MappingProfile
    4. Write the completed ClassModel objects to a local json file
     */
    public String mapFiles(HttpServletRequest request, MultipartFile[] inputFiles) {
        // 1
        String message = _fileService.uploadAllFiles(request, inputFiles);
        // 2
        try {
            parsedClasses = _parser.parse(_fileService.getUploadDirectoryPath());
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Parsing operation failed";
        }
        // 3
        try {
            files.addAll(_profile.map(parsedClasses));
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Mapping operation failed";
        }
        // 4
        try {
            _fileService.writeFilesToJson(files);
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Json operation failed";
        }
        return message;
    }

    @Override
    public List<ClassModel> mapFiles(List<ParsedClass> files) {
        return _profile.map(files);
    }

    @Override
    public List<ParsedClass> getParsedClasses() {
        return parsedClasses;
    }

    @Override
    public List<ClassModel> getFiles() {
        return files;
    }
}