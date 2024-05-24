package it.epicode.GestioneDispositivi.repository;

import it.epicode.GestioneDispositivi.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {
}
