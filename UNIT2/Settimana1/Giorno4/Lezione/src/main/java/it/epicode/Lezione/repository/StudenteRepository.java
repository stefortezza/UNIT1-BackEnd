package it.epicode.Lezione.repository;

import it.epicode.Lezione.bean.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {

    public List<Studente> findByNome(String nome);

    public List<Studente> findByNomeLike(String nome);


}
