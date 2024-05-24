package it.epicode.GestioneDispositivi.service;

import com.cloudinary.Cloudinary;
import it.epicode.GestioneDispositivi.DTO.DipendenteDto;
import it.epicode.GestioneDispositivi.exception.DipendenteNonTrovatoException;
import it.epicode.GestioneDispositivi.exception.DispositivoNonTrovatoException;
import it.epicode.GestioneDispositivi.model.Dipendente;
import it.epicode.GestioneDispositivi.model.Dispositivo;
import it.epicode.GestioneDispositivi.model.Prenotazione;
import it.epicode.GestioneDispositivi.repository.DipendenteRepository;
import it.epicode.GestioneDispositivi.repository.DispositivoRepository;
import it.epicode.GestioneDispositivi.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public String saveDipendente(DipendenteDto dipendenteDto) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);

        Optional<Dispositivo> dispositivoOptional = dispositivoRepository.findById(dipendenteDto.getDispositivoId());
        if (dispositivoOptional.isPresent()) {
            Dispositivo dispositivo = dispositivoOptional.get();
            dispositivo.setPrenotazione(prenotazione);
            prenotazione.setDispositivi(Collections.singletonList(dispositivo));
            dipendente.setPrenotazioni(Collections.singletonList(prenotazione));

            dipendenteRepository.save(dipendente);
            prenotazioneRepository.save(prenotazione);
            dispositivoRepository.save(dispositivo);

            sendMail(dipendente.getEmail());
            return "Dipendente con id " + dipendente.getId() + " salvato correttamente!";
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id= " + dipendenteDto.getDispositivoId() + " non trovato!");
        }
    }

    public Page<Dipendente> getDipendenti(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable);
    }

    public Optional<Dipendente> getDipendenteById(int id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto) {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);

        if (dipendenteOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();

            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome(dipendenteDto.getCognome());
            dipendente.setEmail(dipendenteDto.getEmail());

            Optional<Dispositivo> dispositivoOptional = dispositivoRepository.findById(dipendenteDto.getDispositivoId());
            if (dispositivoOptional.isPresent()) {
                Dispositivo dispositivo = dispositivoOptional.get();

                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setDipendente(dipendente);
                dispositivo.setPrenotazione(prenotazione);
                prenotazione.setDispositivi(Collections.singletonList(dispositivo));
                dipendente.getPrenotazioni().add(prenotazione);

                dipendenteRepository.save(dipendente);
                prenotazioneRepository.save(prenotazione);
                dispositivoRepository.save(dispositivo);
                return dipendente;
            } else {
                throw new DispositivoNonTrovatoException("Dispositivo con id= " + dipendenteDto.getDispositivoId() + " non trovato!");
            }
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id= " + id + " non trovato!");
        }
    }

    public String deleteDipendente(int id) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(id);

        if (dipendenteOptional.isPresent()) {
            dipendenteRepository.delete(dipendenteOptional.get());
            return "Dipendente con id " + id + " cancellato con successo!";
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id= " + id + " non trovato!");
        }
    }

    public String inserisciFotoDipendente(int id, MultipartFile foto) throws IOException {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);

        if (dipendenteOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setFoto(url);

            dipendenteRepository.save(dipendente);

            return "Dipendente con id " + id + " aggiornato correttamente con la foto inviata!";
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id= " + id + " non trovato!");
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Servizio REST");
        message.setText("La registrazione del Dipendente è avvenuta con successo");

        javaMailSender.send(message);
    }
}
