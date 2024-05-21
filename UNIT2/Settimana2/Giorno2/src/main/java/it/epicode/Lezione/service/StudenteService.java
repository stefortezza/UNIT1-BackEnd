package it.epicode.Lezione.service;

import it.epicode.Lezione.acception.StudenteNonTrovatoException;
import it.epicode.Lezione.model.Studente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    private List<Studente> studenti = new ArrayList<>();

    public Optional<Studente> getStudenteByMatricola(int matricola) {
        return studenti.stream().filter(studente -> studente.getMatricola() == matricola).findFirst();
    }

    public List<Studente> getAllStudenti() {
        return studenti;
    }

    public String saveStudente(Studente studente) {
        studenti.add(studente);
        return "Studente creato con questa matricola: " + studente.getMatricola();
    }

    public Studente updateStudente(int matricola, Studente studenteUpdate) throws StudenteNonTrovatoException {
        Optional<Studente> studenteOpt = getStudenteByMatricola(matricola);
        if (studenteOpt.isPresent()) {
            Studente studente = studenteOpt.get();
            studente.setNome(studenteUpdate.getNome());
            studente.setCognome(studenteUpdate.getCognome());
            studente.setDataNascita(studenteUpdate.getDataNascita());
            return studente;
        } else {
            throw new StudenteNonTrovatoException("Studente non trovato");
        }
    }

    public String deleteStudente(int matricola) throws StudenteNonTrovatoException {
        Optional<Studente> studenteOpt = getStudenteByMatricola(matricola);
        if (studenteOpt.isPresent()) {
            studenti.remove(studenteOpt.get());
            return "Studente cancellato";
        } else {
            throw new StudenteNonTrovatoException("Studente non trovato");
        }
    }
}
