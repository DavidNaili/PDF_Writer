package main.java.com.Projekt.PDFWriter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    private static final String MODEL_KEY_INDEX = "index";

    @GetMapping(path = {"/", "/index"})
    public String showIndex() {
        return MODEL_KEY_INDEX;
    }
}
