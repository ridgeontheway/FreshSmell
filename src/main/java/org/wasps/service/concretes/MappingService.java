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

    public String mapFiles(HttpServletRequest request, MultipartFile[] inputFiles) {
        String message = _fileService.uploadAllFiles(request, inputFiles);
        try {
            parsedFiles = _parser.parse(_fileService.getSourceFiles());
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Parsing operation failed";
        }
        try {
            files.addFiles(_profile.map(parsedFiles));
        } catch (Exception e) {
            e.printStackTrace();
            message += "<br>Mapping operation failed";
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
