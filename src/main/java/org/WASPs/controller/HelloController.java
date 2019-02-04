package org.WASPs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    // This is how you tie it to the URL
    @RequestMapping(value = "/greeting")
    public String sayHello (Model model) {
        // model is basically just a hash map - "greeting" is the key
        model.addAttribute("greeting", "SMELL DAT CODE");
        // Name of JSP page is 'hello'
        // Return this .jsp view mapping
        //  which is under /WEB-INF/jsp/hello.jsp
        return "hello";
    }
}
