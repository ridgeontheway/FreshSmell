package org.wasps.service.concretes;

import org.springframework.web.multipart.MultipartFile;
import org.wasps.configuration.MappingProfile;
import org.wasps.data.repository.abstracts.IFileUtility;
import org.wasps.data.repository.abstracts.IJsonUtility;
import org.wasps.model.ParsedDirectory;
import org.wasps.model.fromSourceCode.ParsedClass;
import org.wasps.service.abstracts.IFileService;
import org.wasps.service.abstracts.ISourceCodeParserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class FileService implements IFileService {
    private IFileUtility _fileUtility;
    private IJsonUtility _jsonUtility;
    private MappingProfile _mapper;
    private ISourceCodeParserService _parser;
    private ParsedDirectory parsedFiles;

    public FileService(IFileUtility fileUtility, IJsonUtility jsonUtility, ISourceCodeParserService parser) {
        _fileUtility = fileUtility;
        _jsonUtility = jsonUtility;
        _parser = parser;
        parsedFiles = new ParsedDirectory();
        _mapper = new MappingProfile();
    }

    @Override
    public String uploadAllFiles(HttpServletRequest request, MultipartFile[] files) {
        File directory = _fileUtility.getUploadDirectory(request);
        String message = _fileUtility.uploadAllFiles(directory, files);
        try {
            parseFiles(directory.getPath());
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

    //@Override
   public ParsedDirectory getFiles() {
        return parsedFiles;
    }

    @Override
    public List<ParsedDirectory> getFilesFromJson() {
        return _jsonUtility.getFiles();
    }


        // Parse
    private void parseFiles(String directoryPath) throws Exception {
        _parser.loadInDirectory(directoryPath);
    }


    // Map
    private void mapFiles() throws Exception {
        //fileDirectories = _mapper.map(parsedFiles);
    }
}
