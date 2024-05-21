package it.epicode.GestionePrenotazioni.service;

import it.epicode.GestionePrenotazioni.bean.Edificio;
import it.epicode.GestionePrenotazioni.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void inserisciEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
    }

    public Edificio getEdificio(int id) {
        return edificioRepository.findById(id).get();
    }

    public List<Edificio> getEdificioAll() {
        return edificioRepository.findAll();
    }

    public void cancellaEdificio(int id) {
        edificioRepository.deleteById(id);
    }
}
