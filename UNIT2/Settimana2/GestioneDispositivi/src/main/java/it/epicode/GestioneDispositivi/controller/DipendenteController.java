package it.epicode.GestioneDispositivi.controller;

import it.epicode.GestioneDispositivi.DTO.DipendenteDto;
import it.epicode.GestioneDispositivi.exception.BadRequestException;
import it.epicode.GestioneDispositivi.exception.DipendenteNonTrovatoException;
import it.epicode.GestioneDispositivi.model.Dipendente;
import it.epicode.GestioneDispositivi.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/api/dipendente")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @GetMapping("/api/dipendente")
    public Page<Dipendente> getAllDipendenti(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "15") int size,
                                             @RequestParam(defaultValue = "matricola") String sortBy) {
        return dipendenteService.getDipendenti(page, size, sortBy);
    }

    @GetMapping("/api/dipendente/{id}")
    public Dipendente getDipendenteById(@PathVariable int id) {
        Optional<Dipendente> dipendenteOpt = dipendenteService.getDipendenteById(id);
        if (dipendenteOpt.isPresent()) {
            return dipendenteOpt.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id " + id + " non trovata");
        }
    }

    @PutMapping("/api/dipendente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente updateDipendente(@PathVariable int id, @RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return dipendenteService.updateDipendente(id, dipendenteDto);
    }

    @DeleteMapping("/api/dipendente/{id}")
    public String deleteDipendente(@PathVariable int id) {
        return dipendenteService.deleteDipendente(id);
    }

    @PatchMapping("/api/dipendenti/{id}")
    public String inserisciFotoDipendente(@RequestBody MultipartFile foto, @PathVariable int id) throws IOException {
        return dipendenteService.inserisciFotoDipendente(id, foto);
    }
}
