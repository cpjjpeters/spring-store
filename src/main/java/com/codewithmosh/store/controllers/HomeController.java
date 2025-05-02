package com.codewithmosh.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* carlpeters created on 02/05/2025 inside the package - com.codewithmosh.store.controllers */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
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
