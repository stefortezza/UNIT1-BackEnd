package it.epicode.GestioneEventi.Controller;

import it.epicode.GestioneEventi.DTO.UtenteDto;
import it.epicode.GestioneEventi.Entity.Utente;
import it.epicode.GestioneEventi.Exception.BadRequestException;
import it.epicode.GestioneEventi.Exception.UnauthorizedException;
import it.epicode.GestioneEventi.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @GetMapping("/api/utente")
    @PreAuthorize("hasAnyAuthority('UTENTE_NORMALE', 'ORGANIZZATORE_EVENTI')")
    public List<Utente> getAllUsers() {
        return utenteService.getAllUsers();
    }

    @GetMapping("/api/utente/{id}")
    @PreAuthorize("hasAnyAuthority('UTENTE_NORMALE', 'ORGANIZZATORE_EVENTI')")
    public Utente getUserById(@PathVariable int id) {
        Optional<Utente> utenteOptional = utenteService.getUserById(id);

        if (utenteOptional.isPresent()) {
            return utenteOptional.get();
        } else {
            throw new UnauthorizedException("Utente con id=" + id + " non trovato!");
        }
    }

    @PutMapping("/api/utente/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE_EVENTI')")
    public Utente updateUser(@PathVariable int id, @RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return utenteService.updateUser(id, utenteDto);
    }

    @DeleteMapping("/api/utente/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE_EVENTI')")
    public String deleteUser(@PathVariable int id) {
        return utenteService.deleteUser(id);
    }
}
