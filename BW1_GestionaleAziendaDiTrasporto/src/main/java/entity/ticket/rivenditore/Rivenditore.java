package entity.ticket.rivenditore;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "rivenditori")
public abstract class Rivenditore {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="biglietti_venduti")
    private Integer bigliettiVenduti;
    @Column(name="biglietti_disponibili")
    private Integer bigliettiDisponibili;

    public Rivenditore() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getBigliettiVenduti() {
        return bigliettiVenduti;
    }

    public Integer getBigliettiDisponibili() {
        return bigliettiDisponibili;
    }

    public void aggiungiDisponibilita(Integer quantita) {
        this.bigliettiDisponibili += quantita;
    }

    public void rimuoviDisponibilita(Integer quantita) throws Exception {
        if (this.bigliettiDisponibili - quantita < 0) {
            throw new Exception("Non è stato possibile rimuovere la quantità indicata");
        } else {
            this.bigliettiDisponibili -= quantita;
        }
    }

    public void aggiungiVendita(Integer quantita) throws Exception {
        if (this.bigliettiDisponibili >= quantita) {
            this.bigliettiDisponibili -= quantita;
            this.bigliettiVenduti += quantita;
        } else {
            throw new Exception("Non ci sono abbastanza biglietti disponibili");
        }
    }

    @Override
    public String toString() {
        return "Rivenditore{" +
                "id=" + id +
                ", bigliettiVenduti=" + bigliettiVenduti +
                ", bigliettiDisponibili=" + bigliettiDisponibili +
                '}';
    }
}
