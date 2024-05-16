package it.epicode.Lezione.service;

import it.epicode.Lezione.bean.Computer;
import it.epicode.Lezione.bean.Dispositivo;
import it.epicode.Lezione.bean.Studente;
import it.epicode.Lezione.repository.DispositivoRepository;
import it.epicode.Lezione.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public void InserisciDispositivo(Dispositivo dispositivo) {
        dispositivoRepository.save(dispositivo);
    }

    public Dispositivo getDispositivo(int id) {
        return dispositivoRepository.findById(id).get();
    }

    public List<Dispositivo> getDispositiviAll() {
        return dispositivoRepository.findAll();
    }

    public void cancellaDispositivo(int id) {
        dispositivoRepository.deleteById(id);
    }

    public List<Computer> getComputerByRamLessThan(int ram) {
        return dispositivoRepository.findByRamLessThan(ram);
    }

    public List<Dispositivo> getDispositivoOrderByNome() {
        return dispositivoRepository.findAllOrderByNomeDesc();
    }
}
