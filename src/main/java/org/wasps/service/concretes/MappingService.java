package org.wasps.service.concretes;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.configuration.MappingProfile;
import org.wasps.data.repository.SingletonUtility;
import org.wasps.model.FileModel;
import org.wasps.model.FilesModel;
import org.wasps.model.ParsedFile;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.IMappingService;
import org.wasps.service.abstracts.IParsingService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MappingService implements IMappingService {
    private final MappingProfile _profile;
    private final IFileService _fileService;
    private final IParsingService _parser;
    private List<ParsedFile> parsedFiles;
    private FilesModel files;

    public MappingService() {
        _profile = SingletonUtility.getMappingProfile();
        _fileService = SingletonUtility.getFileService();
        _parser = SingletonUtility.getParser();
        files = new FilesModel();
    }

    /*
    This method is the primary controller of our pipeline for ".java -> FilesModel"
    1. Upload files to working directory
    2. Parse those files into ParedFile models
    3. Map the files from ParsedFile -> FilesModel as defined in MappingProfile
    4. Write the completed FileModel objects to a local json file
     */
    public String mapFiles(HttpServletRequest request, MultipartFile[] inputFiles) {
        // 1
        String message = _fileService.uploadAllFiles(request, inputFiles);
        // 2
        try {
            parsedFiles = _parser.parse(_fileService.getSourceFiles());
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Parsing operation failed";
        }
        // 3
        try {
            files.addFiles(_profile.map(parsedFiles));
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Mapping operation failed";
        }
        // 4
        try {
            _fileService.writeFilesToJson(files.getFiles());
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Json operation failed";
        }
        return message;
    }

    @Override
    public List<FileModel> mapFiles(List<ParsedFile> files) {
        return _profile.map(files);
    }

    @Override
    public List<ParsedFile> getParsedFiles() {
        return parsedFiles;
    }

    @Override
    public FilesModel getFiles() {
        return files;
    }
}
