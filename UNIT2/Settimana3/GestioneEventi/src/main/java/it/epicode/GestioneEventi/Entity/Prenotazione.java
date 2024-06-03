package it.epicode.GestioneEventi.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private int id;

    private String titolo;
    private String descrizione;
    private LocalDate giornoPrenotato;
    private String luogo;
    private int numeroMaxPostiDisponibili;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


}
