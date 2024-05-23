package it.epicode.Lezione.controller;

import it.epicode.Lezione.DTO.AulaDto;
import it.epicode.Lezione.exception.StudenteNonTrovatoException;
import it.epicode.Lezione.model.Aula;
import it.epicode.Lezione.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/* @RequestMapping("/api") //per avere un path root di tutti i path.
 * Viene aggiungo automaticamente a tutti */

public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping("/api/aule")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAula(@RequestBody AulaDto aulaDto) {
        return aulaService.saveAula(aulaDto);
    }

    @GetMapping("/api/aule")
    public List<Aula> getAllAula() {
        return aulaService.getAule();
    }

    @GetMapping("/api/aule/{id}")
    public Aula getAulaById(@PathVariable int id) {
        Optional<Aula> aulaOptional = aulaService.getAulaById(id);
        if (aulaOptional.isPresent()) {
            return aulaOptional.get();
        } else {
            throw new StudenteNonTrovatoException("Stutende con id " + id + " non trovata");
        }
    }

    @PutMapping("/api/aule/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aula updatAula(@PathVariable int id, @RequestBody AulaDto aulaDto) {
        return aulaService.updateAula(id, aulaDto);
    }

    @DeleteMapping("/api/aule/{id}")
    public String deleteAula(@PathVariable int id) {
        return aulaService.deleteAula(id);
    }
}
