package it.panettone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/sample")
    public String sample() {
        return "test/sample"; // Cercherà templates/test/sample.html
    }
}


