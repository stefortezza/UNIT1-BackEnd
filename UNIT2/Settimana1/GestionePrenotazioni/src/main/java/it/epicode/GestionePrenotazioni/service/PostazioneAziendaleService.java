package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.repository.PostazioneAziendaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneAziendaleService {
    @Autowired
    private PostazioneAziendaleRepository postazioneAziendaleRepository;

    public void InserisciPostazioneAziendale(PostazioneAziendale postazioneAziendale) {
        postazioneAziendaleRepository.save(postazioneAziendale);
    }

    public PostazioneAziendale getPostazioneAziendale(Integer codiceUnivoco) {
        return postazioneAziendaleRepository.findById(codiceUnivoco).get();
    }

    public List<PostazioneAziendale> getPostazioneAziendaleAll() {
        return postazioneAziendaleRepository.findAll();
    }

    public void cancellaPostazioneAziendale(int codiceUnivoco) {
        postazioneAziendaleRepository.deleteById(codiceUnivoco);
    }

    public List<PostazioneAziendale> getPostazioneAziendaleByCodiceUnivoco(int codiceUnivoco) {
        return postazioneAziendaleRepository.findByCodiceUnivoco(codiceUnivoco);
    }

}
