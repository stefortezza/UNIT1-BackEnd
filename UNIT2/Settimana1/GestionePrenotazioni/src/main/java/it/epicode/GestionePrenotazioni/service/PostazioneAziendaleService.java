package it.epicode.GestionePrenotazioni.service;
import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.enums.TipoPostazione;
import it.epicode.GestionePrenotazioni.repository.PostazioneAziendaleRepository;
import it.epicode.GestionePrenotazioni.repository.PrenotazioneRepository;
import it.epicode.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PostazioneAziendaleService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneAziendaleRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public List<PostazioneAziendale> ricercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipo, citta);
    }

    public void InserisciPostazioneAziendale(PostazioneAziendale postazioneAziendale) {
        postazioneRepository.save(postazioneAziendale);
    }

    public PostazioneAziendale getPostazioneAziendaleByCodiceUnivoco(Integer codiceUnivoco) {
        return postazioneRepository.findById(codiceUnivoco).get();
    }

    public List<PostazioneAziendale> getPostazioneAziendaleAll() {
        return postazioneRepository.findAll();
    }

    public void cancellaPostazioneAziendalebyCodiceUnivoco(int codiceUnivoco) {
        postazioneRepository.deleteById(codiceUnivoco);
    }

}
