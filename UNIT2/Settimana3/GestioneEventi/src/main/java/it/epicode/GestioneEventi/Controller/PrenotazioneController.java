package it.epicode.GestioneEventi.Controller;

import it.epicode.GestioneEventi.DTO.PrenotazioneDto;
import it.epicode.GestioneEventi.Entity.Prenotazione;
import it.epicode.GestioneEventi.Exception.BadRequestException;
import it.epicode.GestioneEventi.Exception.PrenotazioneNotFoundException;
import it.epicode.GestioneEventi.Service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("/api/prenotazione")
    @PreAuthorize("hasAuthority('UTENTE_NORMALE', 'ORGANIZZATORE_EVENTI')")
    public String savePrenotazione(@RequestBody @Validated PrenotazioneDto prenotazioneDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return prenotazioneService.savePrenotazione(prenotazioneDto);
    }

    @GetMapping("/api/prenotazione")
    @PreAuthorize("hasAnyAuthority('UTENTE_NORMALE', 'ORGANIZZATORE_EVENTI')")
    public List<Prenotazione> getAllPrenotazione() {
        return prenotazioneService.getAllPrenotazione();
    }

    @GetMapping("/api/prenotazione/{id}")
    @PreAuthorize("hasAnyAuthority('UTENTE_NORMALE', 'ORGANIZZATORE_EVENTI')")
    public Prenotazione getPrenotazioneById(@PathVariable int id) {
        Optional<Prenotazione> prenotazioneOptional = prenotazioneService.getPrenotazioneById(id);

        if (prenotazioneOptional.isPresent()) {
            return prenotazioneOptional.get();
        } else {
            throw new PrenotazioneNotFoundException("Prenotazione con id=" + id + " non trovata!");
        }
    }

    @PutMapping("/api/prenotazione/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE_EVENTI')")
    public Prenotazione updatePrenotazione(@PathVariable int id, @RequestBody @Validated PrenotazioneDto prenotazioneDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return prenotazioneService.updatePrenotazione(id, prenotazioneDto);
    }

    @DeleteMapping("/api/prenotazione/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE_EVENTI')")
    public String deletePrenotazione(@PathVariable int id) {
        return prenotazioneService.deletePrenotazione(id);
    }
}
