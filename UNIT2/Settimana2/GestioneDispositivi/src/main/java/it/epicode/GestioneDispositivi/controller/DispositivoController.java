package it.epicode.GestioneDispositivi.controller;

import it.epicode.GestioneDispositivi.DTO.DispositivoDto;
import it.epicode.GestioneDispositivi.exception.BadRequestException;
import it.epicode.GestioneDispositivi.exception.DispositivoNonTrovatoException;
import it.epicode.GestioneDispositivi.model.Dispositivo;
import it.epicode.GestioneDispositivi.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping("/api/dispositivo")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveDispositivo(@RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return dispositivoService.saveDispositivo(dispositivoDto);
    }

    @GetMapping("/api/dispositivo")
    public List<Dispositivo> getAllDispositivo() {
        return dispositivoService.getDispositivi();
    }

    @GetMapping("/api/dispositivo/{id}")
    public Dispositivo getDispositivoById(@PathVariable int id) {
        Optional<Dispositivo> dispositivoOptional = dispositivoService.getDispositiviById(id);
        if (dispositivoOptional.isPresent()) {
            return dispositivoOptional.get();
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato");
        }
    }

    @PutMapping("/api/dispositivo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dispositivo updatDispositivo(@PathVariable int id, @RequestBody @Validated DispositivoDto dispositivoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return dispositivoService.updateDispositivo(id, dispositivoDto);
    }

    @DeleteMapping("/api/dispositivo/{id}")
    public String deleteDispositivo(@PathVariable int id) {
        return dispositivoService.deleteDispositivo(id);
    }
}
