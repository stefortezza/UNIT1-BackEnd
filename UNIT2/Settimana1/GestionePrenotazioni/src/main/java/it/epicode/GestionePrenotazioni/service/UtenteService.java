package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void inserisciUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    public Utente getUtente(int id) {
        return utenteRepository.findById(id).get();
    }

    public List<Utente> getUtenteAll() {
        return utenteRepository.findAll();
    }

    public void cancellaUtente(int id) {
        utenteRepository.deleteById(id);
    }

    public List<Utente> getUtenteByNome(String nome) {
        return utenteRepository.findByNome(nome);
    }

    public List<Utente> getUtenteByPartialNome(String nome) {
        return utenteRepository.findByNomeLike(nome);
    }
}
