package com.example.SimulacroParcial.interfaces;

import com.example.SimulacroParcial.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Integer> {
}
