package it.epicode.GestionePrenotazioni.bean;

import it.epicode.GestionePrenotazioni.enums.TipoPostazione;
import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

import java.util.List;

@Data
@Component
@Entity
public class PostazioneAziendale {
    @Id
    private Integer codiceUnivoco;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private Integer numeroMassimoOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToOne(mappedBy = "postazioneAziendale")
    private Prenotazione prenotazione;
    @ManyToOne
    private Utente utente;

    @Override
    public String toString() {
        return "PostazioneAziendale{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione='" + tipoPostazione + '\'' +
                ", numeroMassimoOccupanti=" + numeroMassimoOccupanti +
                ", edificio=" + edificio.getId() +
                ", utente=" + (utente != null ? utente.getNome() : "Nessun utente") +
                '}';
    }

}
