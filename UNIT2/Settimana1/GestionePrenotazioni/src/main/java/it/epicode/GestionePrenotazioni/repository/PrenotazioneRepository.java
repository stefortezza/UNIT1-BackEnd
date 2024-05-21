package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.bean.Prenotazione;
import it.epicode.GestionePrenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    List<Prenotazione> findByPostazioneAziendaleAndGiornoPrenotato(PostazioneAziendale postazioneAziendale, LocalDate giornoPrenotato);
    List<Prenotazione> findByUtenteAndGiornoPrenotato(Utente utente, LocalDate giornoPrenotato);
}
