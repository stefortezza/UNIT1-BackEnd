    package it.epicode.GestionePrenotazioni.repository;

    import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
    import it.epicode.GestionePrenotazioni.bean.Utente;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;
    import java.util.Optional;

    public interface PostazioneAziendaleRepository extends JpaRepository<PostazioneAziendale, Integer> {
        List<PostazioneAziendale> findByCodiceUnivoco(int codiceUnivoco);
    }
