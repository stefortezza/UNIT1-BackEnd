package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.bean.Prenotazione;
import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.repository.PostazioneAziendaleRepository;
import it.epicode.GestionePrenotazioni.repository.PrenotazioneRepository;
import it.epicode.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PostazioneAziendaleRepository postazioneRepository;

    @Transactional
    public Prenotazione prenotaPostazione(String username, Integer postazioneId, LocalDate giornoPrenotato) throws Exception {
        Utente utente = utenteRepository.findByUsername(username);
        if (utente == null) {
            throw new Exception("Utente non trovato");
        }
        PostazioneAziendale postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new RuntimeException("Postazione non trovata"));

        List<Prenotazione> prenotazioniUtente = prenotazioneRepository.findByUtenteAndGiornoPrenotato(utente, giornoPrenotato);
        if (!prenotazioniUtente.isEmpty()) {
            throw new Exception("L'utente ha già una prenotazione per questa data");
        }

        List<Prenotazione> prenotazioniPostazione = prenotazioneRepository.findByPostazioneAziendaleAndGiornoPrenotato(postazione, giornoPrenotato);
        if (!prenotazioniPostazione.isEmpty()) {
            if (prenotazioniPostazione.size() + 1 > postazione.getNumeroMassimoOccupanti()) {
                throw new Exception("La postazione è occupata in quella data");
            }
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazioneAziendale(postazione);
        prenotazione.setGiornoPrenotato(giornoPrenotato);

        prenotazioneRepository.save(prenotazione);

        postazione.setUtente(utente);
        postazioneRepository.save(postazione);

        return prenotazione;
    }
}
