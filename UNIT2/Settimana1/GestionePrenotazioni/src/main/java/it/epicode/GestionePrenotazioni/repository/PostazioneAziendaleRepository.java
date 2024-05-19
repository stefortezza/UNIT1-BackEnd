package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PostazioneAziendaleRepository extends JpaRepository<PostazioneAziendale, Integer> {
    List<PostazioneAziendale> findByCodiceUnivoco(int codiceUnivoco);

    List<PostazioneAziendale> findByUtenteAndGiornoPrenotato(Utente utente, LocalDate giornoPrenotato);

}
