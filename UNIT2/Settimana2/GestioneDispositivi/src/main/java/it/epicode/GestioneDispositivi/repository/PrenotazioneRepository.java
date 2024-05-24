package it.epicode.GestioneDispositivi.repository;

import it.epicode.GestioneDispositivi.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
}
