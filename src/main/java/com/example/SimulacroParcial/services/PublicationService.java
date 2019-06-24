package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PublicationService {
    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/{id}")
    public void addPublication(@RequestBody Publication publication, @PathVariable("id") Integer id){
        User user = userRepository.getOne(id);
        publication.setUser(user);

        publication.setPublicationDate(LocalDateTime.now());
        publicationRepository.save(publication);
    }

    @GetMapping("")
    public List<Publication> getPublications(){
        return publicationRepository.findAll();
    }
}
