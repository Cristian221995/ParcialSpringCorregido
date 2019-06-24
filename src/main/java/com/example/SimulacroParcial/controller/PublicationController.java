package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import com.example.SimulacroParcial.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationService publicationService;

    @PostMapping("/{id}")
    public void addPublication(@RequestBody Publication publication, @PathVariable("id") Integer id){
        publicationService.addPublication(publication,id);
    }

    @GetMapping("")
    public List<Publication> getPublications(){
        return publicationService.getPublications();
    }
}
