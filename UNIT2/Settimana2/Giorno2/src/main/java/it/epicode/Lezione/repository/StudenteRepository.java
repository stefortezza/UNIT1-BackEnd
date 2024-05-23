package it.epicode.Lezione.repository;

import it.epicode.Lezione.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
}
