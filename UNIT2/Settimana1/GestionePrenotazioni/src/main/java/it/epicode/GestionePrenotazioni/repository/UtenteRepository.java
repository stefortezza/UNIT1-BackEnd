package it.epicode.GestionePrenotazioni.repository;
import it.epicode.GestionePrenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    public List<Utente> findByNome(String nome);

    public List<Utente> findByNomeLike(String nome);
}
