package main.java.com.Projekt.PDFWriter.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {
    
    @RequestMapping(method = RequestMethod.GET, path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health() {
        return "OK";
    }

}
