package it.epicode.Lezione.controller;

import it.epicode.Lezione.acception.StudenteNonTrovatoException;
import it.epicode.Lezione.model.Studente;
import it.epicode.Lezione.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudenteController {

//    @GetMapping("/api")
//    public String benvenuto() {
//        return "benvenuto";
//    }
//
//    @GetMapping("/api/nome_cognome") //gestisce le richieste con i query params (?nome=Stefano&cognome=Fortezza)
//    public String benvenuto2(@RequestParam String nome, String cognome) {
//        return "benvenuto " + nome + " " + cognome;
//    }
//
//    @GetMapping("/api/{nome}/{cognome}")
//    public String benvenuto3(@PathVariable String nome, @PathVariable String cognome) {
//        return "benvenuto " + nome + " " + cognome;
//    }
//
//    @GetMapping ("/api/body")
//    public String benvenuto4(@RequestBody Map<String, String> body) {
//        String nome = body.get("nome");
//        String cognome = body.get("cognome");
//        return "Benvenuto, " + nome + " " + cognome + "!";
//    }

    @Autowired
    private StudenteService studenteService;

    @PostMapping("/api/studenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveStudente(@RequestBody Studente studente) {
        return studenteService.saveStudente(studente);
    }

    @GetMapping("/api/studenti")
    public List<Studente> getAllStudenti() {
        return studenteService.getAllStudenti();
    }

    @GetMapping("/api/studenti/{matricola}")
    public Studente getStudenteByMatricola(@PathVariable int matricola) throws StudenteNonTrovatoException {
        Optional<Studente> studenteOpt = studenteService.getStudenteByMatricola(matricola);
        if (studenteOpt.isPresent()) {
            return studenteOpt.get();
        } else {
            throw new StudenteNonTrovatoException("Stutende con matricola " + matricola + " non trovato");
        }
    }

    @PutMapping("/api/studenti/{matricola}")
    @ResponseStatus(HttpStatus.OK)
    public Studente updateStudente (@PathVariable int matricola, @RequestBody Studente studente) throws StudenteNonTrovatoException{
        return studenteService.updateStudente(matricola, studente);
    }

    @DeleteMapping("/api/studenti/{matricola}")
    public String deleteStudente (@PathVariable int matricola) throws StudenteNonTrovatoException{
        return studenteService.deleteStudente(matricola);
    }

}
