package entity;

import entity.Enum.Periodicità;

import javax.persistence.*;

@Entity
@Table(name = "riviste")
public class Riviste extends ElementoPrestato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Riviste(Long codiceISBN, String titolo, int date, int pagine, Periodicità periodicità) {
        super(codiceISBN, titolo, date, pagine);
        this.periodicità = periodicità;
    }

    public Riviste(){}

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Codice univoco: " + getCodiceISBN() + ", titolo: " + getTitolo() + ", anno di pubblicazione: " + getDate() + ", numero di pagine: " + getPagine() + ", periodicità: " + periodicità;
    }
}
