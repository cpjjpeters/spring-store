package com.codewithmosh.store.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* carlpeters created on 02/05/2025 inside the package - com.codewithmosh.store.controllers */
@Slf4j
@Controller
public class HomeController {
//    private static final Log logger = LogFactory.getLog(MyApplication.class);

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/")
    public String home() {
        log.info("home() has been called ->{} is printed", appName);
        return "index.html";
    }

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("name", "Carl");
        return "hello";
    }

    @RequestMapping("/index2")
    public String sayIndex2(Model model) {
        model.addAttribute("name", "Carl");
        return "index2";
    }
}
