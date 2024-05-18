package it.epicode.GestionePrenotazioni.bean;

import it.epicode.GestionePrenotazioni.bean.Edificio;
import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.enums.DisponibilitaPostazione;
import it.epicode.GestionePrenotazioni.enums.TipoPostazione;
import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Component
@Entity
public class PostazioneAziendale {
    @Id
    private int codiceUnivoco;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private int numeroMassimoOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    private LocalDate giornoPrenotato;
    @Enumerated(EnumType.STRING)
    private DisponibilitaPostazione disponibilitaPostazione;

    public void effettuaPrenotazione(LocalDate giornoPrenotato, Utente utente) {
        if (this.disponibilitaPostazione == DisponibilitaPostazione.LIBERO) {
            this.setGiornoPrenotato(giornoPrenotato);
            this.setUtente(utente);
        } else {
            throw new IllegalArgumentException("La postazione non è disponibile per il giorno specificato.");
        }
    }

    @Override
    public String toString() {
        return "PostazioneAziendale{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione='" + tipoPostazione + '\'' +
                ", numeroMassimoOccupanti=" + numeroMassimoOccupanti +
                ", edificio=" + edificio.getId() +
                ", giornoPrenotato=" + giornoPrenotato +
                ", disponibilitaPostazione=" + disponibilitaPostazione +
                '}';
    }
}
