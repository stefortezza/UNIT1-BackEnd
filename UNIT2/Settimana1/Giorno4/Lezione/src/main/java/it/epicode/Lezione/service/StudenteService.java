package it.epicode.Lezione.service;

import it.epicode.Lezione.bean.Studente;
import it.epicode.Lezione.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    public void InserisciStudente(Studente studente) {
        studenteRepository.save(studente);
    }

    public Studente getStudente(int matricola) {
        return studenteRepository.findById(matricola).get();
    }

    public List<Studente> getStudentiAll() {
        return studenteRepository.findAll();
    }

    public void cancellaStudente(int matricola) {
        studenteRepository.deleteById(matricola);
    }

    public List<Studente> getStudentiByNome(String nome) {
        return studenteRepository.findByNome(nome);
    }

    public List<Studente> getStudentiByPartialNome(String nome) {
        return studenteRepository.findByNomeLike(nome);
    }
}
