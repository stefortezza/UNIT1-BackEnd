package it.epicode.GestioneDispositivi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Dipendente {
    @Id
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String foto;
    private String email;

    @OneToMany(mappedBy = "dipendente", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Prenotazione> prenotazioni;
}
