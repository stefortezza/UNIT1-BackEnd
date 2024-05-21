package it.epicode.GestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "postazione_aziendale_id")
    private PostazioneAziendale postazioneAziendale;

    private LocalDate giornoPrenotato;


    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", utente=" + utente +
                ", postazioniAziendali=" + postazioneAziendale +
                ", giornoPrenotato=" + giornoPrenotato +
                '}';
    }
}
