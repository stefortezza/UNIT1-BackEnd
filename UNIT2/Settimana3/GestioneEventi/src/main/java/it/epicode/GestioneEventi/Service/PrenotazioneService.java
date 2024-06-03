package it.epicode.GestioneEventi.Service;

import it.epicode.GestioneEventi.DTO.PrenotazioneDto;
import it.epicode.GestioneEventi.Entity.Prenotazione;
import it.epicode.GestioneEventi.Exception.PrenotazioneNotFoundException;
import it.epicode.GestioneEventi.Repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public String savePrenotazione(PrenotazioneDto prenotazioneDto) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setLuogo(prenotazioneDto.getLuogo());
        prenotazione.setGiornoPrenotato(prenotazioneDto.getGiornoPrenotato());
        prenotazione.setNumeroMaxPostiDisponibili(prenotazioneDto.getNumeroMaxPostiDisponibili());

        prenotazioneRepository.save(prenotazione);

        return "Prenotazione con id " + prenotazione.getId() + " salvato correttamente!";
    }

    public List<Prenotazione> getAllPrenotazione() {
        return prenotazioneRepository.findAll();
    }

    public Optional<Prenotazione> getPrenotazioneById(int id) {
        return prenotazioneRepository.findById(id);
    }

    public Prenotazione updatePrenotazione(int id, PrenotazioneDto prenotazioneDto) {
        Optional<Prenotazione> prenotazioneOptional = getPrenotazioneById(id);
        if (prenotazioneOptional.isPresent()) {
            Prenotazione prenotazione = prenotazioneOptional.get();
            prenotazione.setLuogo(prenotazioneDto.getLuogo());
            prenotazione.setGiornoPrenotato(prenotazioneDto.getGiornoPrenotato());
            prenotazione.setNumeroMaxPostiDisponibili(prenotazioneDto.getNumeroMaxPostiDisponibili());

            return prenotazioneRepository.save(prenotazione);
        } else {
            throw new PrenotazioneNotFoundException("Prenotazione con id=" + id + " non trovato!");
        }
    }

    public String deletePrenotazione(int id) {
        Optional<Prenotazione> prenotazioneOptional = getPrenotazioneById(id);
        if (prenotazioneOptional.isPresent()) {
            prenotazioneRepository.deleteById(id);
            return "Prenotazione con id=" + id + " cancelato correttamente!";
        } else {
            throw new PrenotazioneNotFoundException("Prenotazione con id=" + id + " non trovato!");
        }
    }
}
