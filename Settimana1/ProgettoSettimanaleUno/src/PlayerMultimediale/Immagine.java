package PlayerMultimediale;

public class Immagine implements ElementoMultimediale {
    private String titolo;
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        this.titolo = titolo;
        this.luminosita = luminosita;
    }

    public String getTitolo() {
        return titolo;
    }

    public boolean isRiproducibile() {
        return false;
    }

    public int getDurata() {
        return 0;
    }

    @Override
    public void play() {
    }

    public void show() {
        StringBuilder asterischi = new StringBuilder(getTitolo());
        for (int i = 0; i < luminosita; i++) {
            asterischi.append("*");
        }
        System.out.println(asterischi.toString());
    }
}
