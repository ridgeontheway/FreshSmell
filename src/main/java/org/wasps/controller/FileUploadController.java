package org.wasps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.wasps.data.SingletonUtility;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController extends BaseController {
    private final HttpServletRequest request;

    @Autowired
    public FileUploadController(HttpServletRequest request) {
        super(SingletonUtility.getWorker());
        this.request = request;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST, consumes = ("multipart/*"))
    public @ResponseBody
    String uploadFiles(@RequestParam("file") MultipartFile[] files) {
        return _worker.mapper().mapFiles(request, files);
    }
}
