package org.wasps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.wasps.configuration.MappingProfile;
import org.wasps.service.concretes.Worker;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController extends BaseController {
    private final HttpServletRequest request;

    @Autowired
    public FileUploadController(HttpServletRequest request) {
        super(new MappingProfile(), new Worker());
        this.request = request;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = {"multipart/*"})
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        File directory = _worker.fileManagementService().createUploadDirectory(request);
        
        try {
            File transferFile = _worker.fileManagementService()
                                    .createUploadFile(directory, file.getOriginalFilename());
            file.transferTo(transferFile);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failure";
        }
        return "Success";
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST, consumes = ("multipart/*"))
    public @ResponseBody
    String uploadFiles(@RequestParam("file") MultipartFile[] files) {
        File directory = _worker.fileManagementService().createUploadDirectory(request);

        StringBuilder message = new StringBuilder();
        for (MultipartFile file : files) {
            if (file.getOriginalFilename().isEmpty())
                continue;
            try {
                File transferFile = _worker.fileManagementService()
                        .createUploadFile(directory, file.getOriginalFilename());
                file.transferTo(transferFile);

//                System.out.println("Transfer File Location => " + transferFile.getAbsolutePath());

                message.append("You successfully uploaded file ");
                message.append(file.getOriginalFilename());
                message.append("<br />");

            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
            }
        }
        return message.toString();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getUpload(Model model) {
        return "upload";
    }

    @RequestMapping(value = "/uploadMultiple", method = RequestMethod.GET)
    public String getUploadMultiple(Model model) {
        return "uploadMultiple";
    }
}
