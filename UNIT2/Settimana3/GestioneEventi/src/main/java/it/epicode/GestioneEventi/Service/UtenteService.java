package it.epicode.GestioneEventi.Service;

import it.epicode.GestioneEventi.DTO.UtenteDto;
import it.epicode.GestioneEventi.Entity.Role;
import it.epicode.GestioneEventi.Entity.Utente;
import it.epicode.GestioneEventi.Exception.UserNotFoundException;
import it.epicode.GestioneEventi.Repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UtenteDto utenteDto) {
        Utente utente = new Utente();
        utente.setName(utenteDto.getName());
        utente.setSurname(utenteDto.getSurname());
        utente.setEmail(utenteDto.getEmail());

        utente.setRole(Role.UTENTE_NORMALE);

        utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));

        utenteRepository.save(utente);

        return "L'utente con id " + utente.getId() + " salvato correttamente!";
    }

    public List<Utente> getAllUsers() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUserById(int id) {
        return utenteRepository.findById(id);
    }

    public Utente getUserByEmail(String email) {
        Optional<Utente> userOptional = utenteRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserNotFoundException("Utente con email=" + email + " non trovato!");
        }
    }

    public Utente updateUser(int id, UtenteDto utenteDto) {
        Optional<Utente> utenteOptional = getUserById(id);
        if (utenteOptional.isPresent()) {
            Utente utente = utenteOptional.get();
            utente.setName(utenteDto.getName());
            utente.setSurname(utenteDto.getSurname());
            utente.setEmail(utenteDto.getEmail());

            utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));

            return utenteRepository.save(utente);
        } else {
            throw new UserNotFoundException("Utente con id=" + id + " non trovato!");
        }
    }

    public String deleteUser(int id) {
        Optional<Utente> utenteOptional= getUserById(id);
        if (utenteOptional.isPresent()) {
            utenteRepository.deleteById(id);
            return "User con id=" + id + "cancellato correttamente!";
        } else {
            throw new UserNotFoundException("Utente con id=" + id + " non trovato!");
        }
    }
}
