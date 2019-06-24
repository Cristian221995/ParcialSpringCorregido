package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.ComentaryRepository;
import com.example.SimulacroParcial.interfaces.PublicationRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.Comentary;
import com.example.SimulacroParcial.models.Publication;
import com.example.SimulacroParcial.models.User;
import com.example.SimulacroParcial.services.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comentary")
public class ComentaryController {

    @Autowired
    CommentaryService commentaryService;

    @PostMapping("/{id}/{idUsuario}")
    public void addComentary(@RequestBody Comentary comentary, @PathVariable("id") Integer id, @PathVariable("idUsuario") Integer idUsuario){
        commentaryService.addComentary(comentary,id,idUsuario);
    }

    @GetMapping("")
    public List<Comentary> getCommentary(){
        return commentaryService.getCommentary();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComentary(@PathVariable("id") Integer id){
        commentaryService.deleteComentary(id);
    }

}
