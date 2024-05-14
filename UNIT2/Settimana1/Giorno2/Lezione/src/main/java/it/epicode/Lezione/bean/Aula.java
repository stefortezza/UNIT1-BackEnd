package it.epicode.Lezione.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component ("aula1") //Permette di Generare oggetti di tipo Aula direttamente da Spring
@PropertySource("application.properties")
public class Aula {
    @Value("${aula.nome}") //OGGLIGATORIO INSEIRE: +@PropertySource("application.properties")

    private String nome;
    //inietta la lista di studenti prendendoli direttamente dal contesto
    @Autowired
    private List<Studente> studenti;



//    @Autowired
    //Spring andra` a verificare se vi sono Studenti, e li inserisce
    //li innietta direttamente all`interno della Lista Aula
//    public Aula (List<Studente> studenti) {
//        this.studenti = studenti;
//    }

    //crea prima un oggetto Aula vuoto e poi lo setta nell`aula una lista
    //di studenti
//    @Autowired
//    public void setStudenti (List<Studente> studenti) {
//        this.studenti = studenti;
//    }


}
