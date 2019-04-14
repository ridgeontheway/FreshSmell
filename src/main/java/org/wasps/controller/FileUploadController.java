package org.wasps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.wasps.data.SingletonUtility;
import org.wasps.model.ClassModel;
import org.wasps.model.FileMappingResultModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Handles requests for the application file upload requests
 */
@Controller
@SessionAttributes("classmodel")
public class FileUploadController extends BaseController {
    private final HttpServletRequest request;

    @Autowired
    public FileUploadController(HttpServletRequest request) {
        super(SingletonUtility.getWorker(), SingletonUtility.getClassService());
        this.request = request;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST, consumes = ("multipart/*"))
    public String uploadFiles(@RequestParam("file") MultipartFile[] files, Model model) {
        FileMappingResultModel uploadResult = new FileMappingResultModel();

        uploadResult.setResultMessage(_worker.mapper().mapFiles(request, files));

        List<ClassModel> classes = _classes.get();
        classes.stream().parallel().forEach(c ->
                c.addSmellReports(_worker
                                        .smellerService()
                                        .performSmells(c)));

        uploadResult.setUploads(classes);

//        return result.getResultMessage();
        return "smell";
    }
}
