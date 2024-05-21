package it.epicode.GestionePrenotazioni.repository;

import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneAziendaleRepository extends JpaRepository<PostazioneAziendale, Integer> {
    List<PostazioneAziendale> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipo, String citta);
}
