package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libri extends ElementoPrestato {
    private String autore;
    private String genere;
    private LocalDate annoDiPubblicazione;

    public Libri(Long codiceISBN, String titolo, int date, int pagine, String autore, String genere, LocalDate annoDiPubblicazione) {
        super(codiceISBN, titolo, date, pagine);
        this.autore = autore;
        this.genere = genere;
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public Libri() {
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public LocalDate getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(LocalDate annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    @Override
    public String toString() {
        return "Codice univoco: " + getCodiceISBN() + ", titolo: " + getTitolo() + ", anno di pubblicazione: " + getDate() + ", numero di pagine: " + getPagine() + ", autore: " + autore + ", genere: " + genere;
    }
}
