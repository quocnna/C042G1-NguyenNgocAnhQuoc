package qg.exercise.controller;

import jdk.incubator.jpackage.internal.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;
import qg.exercise.repository.PictureRepository;
import qg.exercise.service.PictureService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


@Controller
public class PictureController {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private PictureService pictureService;
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/image-resource", method = RequestMethod.GET)
    public Resource getImageAsResource() {
        return new ServletContextResource(servletContext, "/WEB-INF/images/placeholder.jpg");
    }

}
