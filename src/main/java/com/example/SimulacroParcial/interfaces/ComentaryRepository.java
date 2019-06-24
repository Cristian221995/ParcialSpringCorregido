package com.example.SimulacroParcial.interfaces;

import com.example.SimulacroParcial.models.Comentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentaryRepository extends JpaRepository<Comentary, Integer> {
}
