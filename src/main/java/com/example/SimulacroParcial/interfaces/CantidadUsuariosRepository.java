package com.example.SimulacroParcial.interfaces;

import com.example.SimulacroParcial.models.CantidadUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CantidadUsuariosRepository extends JpaRepository<CantidadUsuarios, String> {
    String NATIVE_QUERY = "select count(user.id) as cantidad from user;";
    @Query(value = NATIVE_QUERY , nativeQuery = true)
    CantidadUsuarios getCant();
}
