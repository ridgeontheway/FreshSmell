package org.wasps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@SpringBootApplication
public class FreshsmellApplication {

    private static TemplateEngine templateEngine;


    public static void main(String[] args) {
        SpringApplication.run(FreshsmellApplication.class, args);
    }

    static {
        initializeTemplateEngine();
    }

    private static void initializeTemplateEngine() {

        SpringResourceTemplateResolver templateResolver =
                new SpringResourceTemplateResolver();
        templateResolver.setTemplateMode("HTML");
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(3600000L);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

    }
}
