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

        File directory = _worker.fileManagementService().createDirectory(request);

        try {
            File transferFile = _worker.fileManagementService()
                                    .createFile(directory, file.getOriginalFilename());
            file.transferTo(transferFile);

            System.out.println(transferFile.getPath());
        } catch (Exception e) {

            e.printStackTrace();

            return "Failure";
        }

        return "Success";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getUpload(Model model) {
        return "upload";
    }

/*
    Don't delete these yet - they're for reference for multipart file uploads later on
 */

// @Controller
//public class FileUploadController extends BaseController {
//    private final HttpServletRequest request;
//
//    @Autowired
//    public FileUploadController(HttpServletRequest request) {
//        super(new MappingProfile(), new Worker());
//        this.request = request;
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String homePage() {
//        return "home";
//    }
//
//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = {"multipart/*"})
//    @ResponseBody
//    public String uploadFile(@RequestParam("file") MultipartFile file) {
//
//        String uploadDirectoryName = "/uploads";
//        String uploadPath = request.getServletContext().getRealPath(uploadDirectoryName);
//        File directory = new File(uploadPath + "/");
//
//        try {
//
//            File transferFile = null;
//
//            try {
//                if (directory.mkdirs())
//                    transferFile = new File(uploadPath + "/" + file.getOriginalFilename());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            file.transferTo(transferFile);
//
//
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            return "Failure";
//        }
//
//        return "Success";
//    }


    /*
     * Upload single file using Spring Controller
     */
//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, consumes = ("multipart/*"))
//    public @ResponseBody
//    String uploadFileHandler(@RequestParam("name") String name,
//                             @RequestParam("file") MultipartFile file) {
//
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//
//                // Creating the directory to store file
//                String rootPath = System.getProperty("catalina.home");
//                File dir = new File(rootPath + File.separator + "tmpFiles");
//                if (!dir.exists())
//                    //noinspection ResultOfMethodCallIgnored
//                    dir.mkdirs();
//
//                // Create the file on server
//                File serverFile = new File(dir.getAbsolutePath()
//                        + File.separator + name);
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(serverFile));
//                stream.write(bytes);
//                stream.close();
//
//                System.out.println("Server File Location="
//                        + serverFile.getAbsolutePath());
//
//                return "You successfully uploaded file=" + name;
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + name
//                    + " because the file was empty.";
//        }
//    }
//
//    /**
//     * Upload multiple file using Spring Controller
//     */
//    @RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST, consumes = ("multipart/*"))
//    public @ResponseBody
//    String uploadMultipleFileHandler(@RequestParam("name") String[] names,
//                                     @RequestParam("file") MultipartFile[] files) {
//
//        if (files.length != names.length)
//            return "Mandatory information missing";
//
//        String message = "";
//        for (int i = 0; i < files.length; i++) {
//            MultipartFile file = files[i];
//            String name = names[i];
//            try {
//                byte[] bytes = file.getBytes();
//
//                // Creating the directory to store file
//                String rootPath = System.getProperty("catalina.home");
//                File dir = new File(rootPath + File.separator + "tmpFiles");
//                if (!dir.exists())
//                    //noinspection ResultOfMethodCallIgnored
//                    dir.mkdirs();
//
//                // Create the file on server
//                File serverFile = new File(dir.getAbsolutePath()
//                        + File.separator + name);
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(serverFile));
//                stream.write(bytes);
//                stream.close();
//
//                System.out.println("Server File Location="
//                        + serverFile.getAbsolutePath());
//
//                message = message + "You successfully uploaded file=" + name
//                        + "<br />";
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        }
//        return message;
//    }
}
