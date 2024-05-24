package it.epicode.GestioneDispositivi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    @OneToMany(mappedBy = "prenotazione",fetch = FetchType.EAGER )
    private List<Dispositivo> dispositivi;
}
