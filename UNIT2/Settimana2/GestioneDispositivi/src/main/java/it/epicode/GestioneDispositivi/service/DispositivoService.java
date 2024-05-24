package it.epicode.GestioneDispositivi.service;

import com.cloudinary.Cloudinary;
import it.epicode.GestioneDispositivi.DTO.*;
import it.epicode.GestioneDispositivi.exception.DispositivoNonTrovatoException;
import it.epicode.GestioneDispositivi.model.Dipendente;
import it.epicode.GestioneDispositivi.model.Dispositivo;
import it.epicode.GestioneDispositivi.model.Smartphone;
import it.epicode.GestioneDispositivi.repository.DipendenteRepository;
import it.epicode.GestioneDispositivi.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public String saveDispositivo(DispositivoDto dispositivoDto) {
        Dispositivo dispositivo = new Dispositivo();
//        dispositivo.setTipoDispositivo(dispositivoDto.getTipoDispositivo());
        dispositivoRepository.save(dispositivo);
        return "Dispositivo con id= " + dispositivo.getId() + " creato con successo!";
    }

    public List<Dispositivo> getDispositivi() {
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivo> getDispositiviById(int id) {
        return dispositivoRepository.findById(id);
    }

    public Dispositivo updateDispositivo(int id, DispositivoDto dispositivoDto) {
        Optional<Dispositivo> dispositivoOptional = getDispositiviById(id);

        if (dispositivoOptional.isPresent()) {
            Dispositivo dispositivo = dispositivoOptional.get();
//            dispositivo.setTipoDispositivo(dispositivoDto.getTipoDispositivo());

            return dispositivoRepository.save(dispositivo);
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato!");
        }
    }

    public String deleteDispositivo(int id) {
        Optional<Dispositivo> dispositivoOptional = getDispositiviById(id);
        if (dispositivoOptional.isPresent()) {
            dispositivoRepository.delete(dispositivoOptional.get());
            return "Dispositivo con id " + id + " cancellato con successo!";
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato!");
        }
    }

}
