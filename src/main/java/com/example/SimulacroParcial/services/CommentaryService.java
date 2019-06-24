package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.interfaces.ComentaryRepository;
import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.Comentary;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentaryService {
    @Autowired
    ComentaryRepository comentaryRepository;

    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/{id}/{idUsuario}")
    public void addComentary(@RequestBody Comentary comentary, @PathVariable("id") Integer id, @PathVariable("idUsuario") Integer idUsuario){
        Publication publication = publicationRepository.getOne(id);
        comentary.setPublication(publication);

        User user = userRepository.getOne(idUsuario);
        comentary.setUser(user);

        comentary.setDate(LocalDateTime.now());
        comentaryRepository.save(comentary);
    }

    @GetMapping("")
    public List<Comentary> getCommentary(){
        return comentaryRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComentary(@PathVariable("id") Integer id){
        comentaryRepository.deleteById(id);
    }

    @Scheduled(cron="${cronExpression}")
    public void deleteTime(){
        List<Comentary> list= comentaryRepository.findAll();
        for (Comentary c: list){
            comentaryRepository.deleteById(c.getId());
        }
    }

}
