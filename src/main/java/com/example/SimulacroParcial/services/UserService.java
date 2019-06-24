package com.example.SimulacroParcial.services;

import com.example.SimulacroParcial.interfaces.PublicacionesXUsuario;
import com.example.SimulacroParcial.interfaces.CantidadUsuariosRepository;
import com.example.SimulacroParcial.interfaces.UserRepository;
import com.example.SimulacroParcial.models.CantidadUsuarios;
import com.example.SimulacroParcial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CantidadUsuariosRepository cantidadUsuariosRepository;

    public void addUser(@RequestBody User user, HttpServletRequest request){
        user.setBrowser(this.getUserAgent(request));
        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(@PathVariable("id") Integer id){
        return userRepository.getOne(id);
    }

    public void modifyUser(@PathVariable("id") Integer id, @RequestBody User user){
        User aux = userRepository.getOne(id);
        user.setId(aux.getId());
        userRepository.save(user);
    }

    public void deleteUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    private String getUserAgent(HttpServletRequest request) {
        return request.getHeader("user-agent");
    }

    public List<PublicacionesXUsuario> getCantidadPublicaciones(){
        return userRepository.getCantPublic();
    }

    public CantidadUsuarios getCantidad(){
        return cantidadUsuariosRepository.getCant();
    }

}
