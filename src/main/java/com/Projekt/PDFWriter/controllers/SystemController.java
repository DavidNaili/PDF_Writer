package main.java.com.Projekt.PDFWriter.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import main.java.com.Projekt.PDFWriter.Entity.Systems;

@RestController
@RequestMapping("systems")
public class SystemController {
    @RequestMapping(method = RequestMethod.GET, path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Systems> getDevices() {
        final List<Systems> deviceList = Systems.getSystemList();
        return deviceList;
    }
}
