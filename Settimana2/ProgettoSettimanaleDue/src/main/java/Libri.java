import java.util.Date;

public class Libri {
    private Long codiceISBN;
    private String titolo;
    private int date;
    private int pagine;
    private String autore;
    private String genere;

    public Libri(Long codiceISBN, String titolo, int date, int pagine, String autore, String genere) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.date = date;
        this.pagine = pagine;
        this.autore = autore;
        this.genere = genere;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
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

    @Override
    public String toString() {
        return "Codice univoco: " + codiceISBN + ", titolo: " + titolo + ", anno di pubblicazione: " + date + ", numero di pagine: " + pagine + ", autore: " + autore + ", genere: " + genere;
    }
}
