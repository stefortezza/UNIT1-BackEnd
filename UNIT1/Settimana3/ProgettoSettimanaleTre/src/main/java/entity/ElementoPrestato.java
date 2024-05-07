package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "elementoPrestato")
public class ElementoPrestato {
    @Id
    @GeneratedValue
    private int id;
    private Long codiceISBN;
    private String titolo;
    private LocalDate annoPubblicazione;
    private int pagine;

    public ElementoPrestato(int id, Long codiceISBN, String titolo, int annoPubblicazione, int pagine) {
        this.id = id;
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = LocalDate.ofEpochDay(annoPubblicazione);
        this.pagine = pagine;
    }

    public ElementoPrestato() {
    }

    public ElementoPrestato(Long codiceISBN, String titolo, int date, int pagine) {
    }

    public Long getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(Long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDate() {
        return annoPubblicazione;
    }

    public void setDate(LocalDate date) {
        this.annoPubblicazione = date;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ElementoPrestato{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", date=" + annoPubblicazione +
                ", pagine=" + pagine +
                '}';
    }
}
