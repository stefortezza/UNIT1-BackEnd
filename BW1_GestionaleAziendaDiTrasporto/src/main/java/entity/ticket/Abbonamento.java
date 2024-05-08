package entity.ticket;

import entity.utente.Tessera;
import enums.TipoAbbonamento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="abbonamenti")
public class Abbonamento extends Ticket {
    @Enumerated(value = EnumType.STRING)
    @Column(name="tipo_abbonamento")
    private TipoAbbonamento tipoAbbonamento;
    @Column(name="data_scadenza")
    private LocalDate dataScadenza;
    @OneToOne
    @JoinColumn(name="tessera_id")
    private Tessera tessera;

    public Abbonamento(TipoAbbonamento tipoAbbonamento, LocalDate dataEmissione, Tessera tessera) {
        this.tipoAbbonamento = tipoAbbonamento;
        this.dataEmissione = dataEmissione;
        if (tipoAbbonamento == TipoAbbonamento.SETTIMANALE) {
            this.dataScadenza = dataEmissione.plusWeeks(1);
        } else if (tipoAbbonamento == TipoAbbonamento.MENSILE) {
            this.dataScadenza = dataEmissione.plusMonths(1);
        } else {
            System.err.println("Tipo di abbonamento non presente");
        }
        this.tessera = tessera;
    }

    public Abbonamento() {

    }

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    @Override
    public void setDataEmissione(LocalDate dataEmissione) throws Exception {
        if (this.tipoAbbonamento != null) {
            this.dataEmissione = dataEmissione;
            if (this.tipoAbbonamento == TipoAbbonamento.SETTIMANALE) {
                this.dataScadenza = dataEmissione.plusWeeks(1);
            } else if (this.tipoAbbonamento == TipoAbbonamento.MENSILE) {
                this.dataScadenza = dataEmissione.plusMonths(1);
            } else {
                System.err.println("Tipo di abbonamento non presente");
            }
        } else {
            throw new Exception("Devi impostare prima il tipo di abbonamento");
        }
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }
}
