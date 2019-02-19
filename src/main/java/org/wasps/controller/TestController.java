package org.wasps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("test")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest(Model model) {
        model.addAttribute("greeting", "Hello World!");

        return "test";
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        // Forward passes request along to this page
        // Same response objects, we're building onto them
        return "forward:index.jsp";
    }
}
