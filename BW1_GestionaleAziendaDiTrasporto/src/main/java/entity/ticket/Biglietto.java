package entity.ticket;

import entity.mezzo.Mezzo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="biglietti")
public class Biglietto extends Ticket {
    private LocalDateTime vidimazione;
    private LocalDateTime scadenza;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;


    public Biglietto() {
    }

    public LocalDateTime getVidimazione() {
        return vidimazione;
    }

    public LocalDateTime getScadenza() {
        return scadenza;
    }

    public void setVidimazione(LocalDateTime vidimazione, Mezzo mezzo) throws Exception {
        if (this.mezzo == null) {
            this.mezzo = mezzo;
            this.vidimazione = vidimazione;
            this.scadenza = vidimazione.plusMinutes(90); //Biglietto da 90 minuti
        } else {
            throw new Exception("Questo biglietto è stato già vidimato");
        }
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "dataEmissione=" + dataEmissione +
                ", mezzo=" + mezzo +
                ", scadenza=" + scadenza +
                ", vidimazione=" + vidimazione +
                '}';
    }
}
