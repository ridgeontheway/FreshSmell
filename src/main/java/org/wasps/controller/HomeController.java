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
import org.wasps.model.ProjectSmellReport;
import org.wasps.viewmodel.ProjectSmellReportViewModel;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the applicMation file upload requests
 */
@Controller
@SessionAttributes("classmodel")
public class HomeController extends BaseController {
    private final HttpServletRequest request;

    @Autowired
    public HomeController(HttpServletRequest request) {
        super(SingletonUtility.getWorker());
        this.request = request;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/smell", method = RequestMethod.POST, consumes = ("multipart/*"))
    public String uploadFiles(@RequestParam("file") MultipartFile[] files, Model model) {
        String message = _worker.mapper().mapFiles(request, files);
        System.out.println(message);

        ProjectSmellReport report = _worker.reportService().generateProjectSmellReport();
        ProjectSmellReportViewModel viewModel = _worker.mapper().mapToViewModel(report);

        model.addAttribute("report", viewModel);
        model.addAttribute("classes", viewModel.getClasses());
        model.addAttribute("messages", viewModel.getReportMessages());

        return "smell";
    }
}
