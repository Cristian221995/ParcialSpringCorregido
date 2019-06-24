package com.example.SimulacroParcial.interfaces;

import com.example.SimulacroParcial.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    String NATIVE_QUERY = "select user.name, user.surname, count(publication.id) as cantidad from user inner join publication on user.id = publication.id_user group by user.name, user.surname order by user.name, user.surname;";
    @Query(value = NATIVE_QUERY , nativeQuery = true)
    List<PublicacionesXUsuario> getCantPublic();
}
