package entity.ticket;

import entity.mezzo.Mezzo;
import entity.ticket.rivenditore.Rivenditore;
import enums.TipoAbbonamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="tickets")
public abstract class Ticket {
    @Id
    @GeneratedValue
    private Integer id;
    private Double prezzo;
    @Column(name="data_emissione")
    protected LocalDate dataEmissione;
    @ManyToMany
    @JoinTable(
            name = "rivenditori_tickets",
            joinColumns = @JoinColumn(name="ticket_id"),
            inverseJoinColumns = @JoinColumn(name="rivenditore_id")
    )
    private List<Rivenditore> rivenditori;

    public Ticket(Double prezzo, LocalDate dataEmissione) {
        this.prezzo = prezzo;
        this.dataEmissione = dataEmissione;
        this.rivenditori = new ArrayList<>();
    }

    public Ticket() {
        this.rivenditori = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public List<Rivenditore> getRivenditori() {
        return rivenditori;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public void aggiungiRivenditore(Rivenditore rivenditore) throws Exception {
        if (this.rivenditori.contains(rivenditore)) {
            throw new Exception("Questo rivenditore è già associato al biglietto");
        } else {
            this.rivenditori.add(rivenditore);
        }
    }

    public void rimuoviRivenditore(Rivenditore rivenditore) throws Exception {
        boolean rimosso = this.rivenditori.removeIf(r -> r.getId().equals(rivenditore.getId()));
        if (rimosso) {
            System.out.println("Rivenditore rimosso correttamente");
        } else {
            throw new Exception("Il rivenditore non è associato al biglietto");
        }
    }

    public void setDataEmissione(LocalDate dataEmissione) throws Exception {
        this.dataEmissione = dataEmissione;
    }
}
