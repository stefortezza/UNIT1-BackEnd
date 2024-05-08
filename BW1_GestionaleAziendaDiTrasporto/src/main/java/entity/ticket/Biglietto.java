package entity.ticket;

import entity.mezzo.Mezzo;
import enums.TipoBiglietto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="biglietti")
public class Biglietto extends Ticket {
    private LocalDateTime vidimazione;
    private LocalDateTime scadenza;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_biglietto")
    private TipoBiglietto tipoBiglietto;

    public Biglietto(TipoBiglietto tipoBiglietto) {
        this.tipoBiglietto = tipoBiglietto;
    }

    public Biglietto() {
    }

    public LocalDateTime getVidimazione() {
        return vidimazione;
    }

    public TipoBiglietto getTipoBiglietto() {
        return tipoBiglietto;
    }

    public void setTipoBiglietto(TipoBiglietto tipoBiglietto) {
        this.tipoBiglietto = tipoBiglietto;
    }

    public LocalDateTime getScadenza() {
        return scadenza;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setVidimazione(LocalDateTime vidimazione, Mezzo mezzo) throws Exception {
        if (this.mezzo == null) {
            if (this.tipoBiglietto != null) {
                this.mezzo = mezzo;
                this.vidimazione = vidimazione;
                if (this.tipoBiglietto == TipoBiglietto.MINUTI_90) {
                    this.scadenza = vidimazione.plusMinutes(90); //Biglietto da 90 minuti
                } else if (this.tipoBiglietto == TipoBiglietto.GIORNALIERO) {
                    this.scadenza = vidimazione.plusDays(1);
                } else if (this.tipoBiglietto == TipoBiglietto.CORSA_SINGOLA) {
                    this.scadenza = vidimazione;
                }
            } else {
                throw new Exception("Non è stata specificata la tipologia di biglietto");
            }
        } else {
            throw new Exception("Questo biglietto è stato già vidimato");
        }
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "vidimazione=" + vidimazione +
                ", scadenza=" + scadenza +
                ", mezzo=" + mezzo +
                ", tipoBiglietto=" + tipoBiglietto +
                ", dataEmissione=" + dataEmissione +
                '}';
    }
}
