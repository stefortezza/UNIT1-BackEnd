import java.util.Date;

public class Riviste {

    private Periodicità periodicità;

    private Long codiceISBN;
    private String titolo;
    private int date;
    private int pagine;

    public Riviste(Long codiceISBN, String titolo, int date, int pagine, Periodicità periodicità) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.date = date;
        this.pagine = pagine;
        this.periodicità = periodicità;
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

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Codice univoco: " + codiceISBN + ", titolo: " + titolo + ", anno di pubblicazione: " + date + ", numero di pagine: " + pagine + ", periodicità: " + periodicità;
    }
}
