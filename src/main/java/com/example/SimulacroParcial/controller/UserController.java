package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.PublicacionesXUsuario;
import com.example.SimulacroParcial.models.CantidadUsuarios;
import com.example.SimulacroParcial.models.User;
import com.example.SimulacroParcial.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public void addUser(@RequestBody User user, HttpServletRequest request){
        userService.addUser(user,request);
    }

    @GetMapping("")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @PatchMapping("/{id}")
    public void modifyUser(@PathVariable("id") Integer id, @RequestBody User user){
        userService.modifyUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

    @GetMapping("/getCantPub")
    public List<PublicacionesXUsuario> getCantidadPublicaciones(){
        return userService.getCantidadPublicaciones();
    }

    @GetMapping("/getCantPub2")
    public CantidadUsuarios getCantidad(){
        return userService.getCantidad();
    }

    @Async("threadPoolTaskExecutor")
    public List methodOne() {
        return this.getCantidadPublicaciones();
    }

    @Async("threadPoolTaskExecutor")
    public CantidadUsuarios methodTwo() {
        return this.getCantidad();
    }

    @GetMapping("/async")
    public List getAsync(){
        List lista = this.methodOne();
        CantidadUsuarios cant = this.methodTwo();
        lista.add(cant);

        return lista;
    }

}
