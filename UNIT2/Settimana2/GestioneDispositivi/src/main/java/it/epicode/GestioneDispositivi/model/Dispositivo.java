package it.epicode.GestioneDispositivi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.GestioneDispositivi.enums.TipoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo {
    @Id
    private int id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoDispositivo tipoDispositivo;

    @ManyToOne
    @JoinColumn(name = "prenotazione_id")
    @JsonIgnore
    private Prenotazione prenotazione;
}
