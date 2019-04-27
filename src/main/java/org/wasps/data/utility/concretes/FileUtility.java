package org.wasps.data.utility.concretes;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.wasps.data.utility.abstracts.IFileUtility;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileUtility implements IFileUtility {
    private final String UPLOAD_DIRECTORY_NAME;
    private String _uploadDirectoryPath;
    private File _uploadDirectory;

    public FileUtility(String directoryName) {
        UPLOAD_DIRECTORY_NAME = directoryName;
    }

    public File createUploadDirectory(HttpServletRequest request) {
        _uploadDirectoryPath = request.getServletContext().getRealPath(UPLOAD_DIRECTORY_NAME) + "/";
        _uploadDirectory = new File(_uploadDirectoryPath);

        if (!_uploadDirectory.exists()) {
            //noinspection ResultOfMethodCallIgnored
            _uploadDirectory.mkdirs();
        } else {
            try {
                // If directory exists, remove all files before uploading
                FileUtils.cleanDirectory(_uploadDirectory);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Directory:\t" + _uploadDirectory.getAbsolutePath());
        }
        return _uploadDirectory;
    }

    public File createUploadFile(File directory, String name) {
        return new File(directory.getPath() + "/" + name);
    }

    @Override
    public String uploadFile(File directory, MultipartFile file) {
        try {
            File transferFile = createUploadFile(directory, file.getOriginalFilename());
            file.transferTo(transferFile);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
        return "Success";
    }

    @Override
    public String uploadAllFiles(File directory, MultipartFile[] files) {
        StringBuilder message = new StringBuilder();
        for (MultipartFile file : files) {
            if (file.getOriginalFilename().isEmpty())
                continue;
            try {
                File transferFile = createUploadFile(directory, file.getOriginalFilename());
                file.transferTo(transferFile);

                System.out.println("Transfer File Location => " + transferFile.getAbsolutePath());

                message.append("You successfully uploaded file ");
                message.append(file.getOriginalFilename());

            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
            }
        }
        return message.toString();
    }


    @Override
    public File getUploadedFileByNameAndType(String queryName) {
        File[] files = _uploadDirectory.listFiles((dir, name) -> name.equalsIgnoreCase(queryName));

        if (files == null)
            return null;

        return files[0];
    }

    @Override
    public List<File> getUploadedFilesByType(String queryType) {
        File[] files = _uploadDirectory.listFiles((dir, name) -> name.endsWith(queryType));

        if (files == null)
            return null;

        return Arrays.asList(files);
    }

    @Override
    public List<File> getUploadedFiles() {
        File[] files = _uploadDirectory.listFiles();

        if (files == null)
            return null;

        return Arrays.asList(files);
    }

    @Override
    public File getUploadDirectory() {
        return _uploadDirectory;
    }

    @Override
    public File getUploadDirectory(HttpServletRequest request) {
        if (_uploadDirectory == null || !_uploadDirectory.exists())
            createUploadDirectory(request);

        return _uploadDirectory;
    }

    @Override
    public String getUploadDirectoryPath() { return _uploadDirectoryPath; }
}
