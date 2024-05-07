package entity.utente;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tessere")
public class Tessera {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @Column(name="data_emissione")
    private LocalDate dataEmissione;
    @Column(name="data_scadenza")
    private LocalDate dataScadenza;

    public Tessera(Utente utente, LocalDate dataEmissione) {
        this.utente = utente;
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataEmissione.plusYears(1);
    }

    public Tessera() {

    }

    public Integer getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataEmissione.plusYears(1);
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id=" + id +
                ", utente=" + utente +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}
