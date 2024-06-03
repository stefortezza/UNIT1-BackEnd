package it.epicode.GestioneEventi.Repository;

import it.epicode.GestioneEventi.Entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
}
