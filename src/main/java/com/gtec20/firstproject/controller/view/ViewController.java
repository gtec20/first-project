package com.gtec20.firstproject.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("")
    public String login(Model model) {
        return "page/login";
    }
}
