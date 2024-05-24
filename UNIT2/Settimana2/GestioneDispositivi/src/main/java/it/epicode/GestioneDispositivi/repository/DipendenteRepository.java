package it.epicode.GestioneDispositivi.repository;

import it.epicode.GestioneDispositivi.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
}
