package PlayerMultimediale;

import java.util.Scanner;

public class Video implements ElementoMultimediale {
    private String titolo;
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        this.titolo = titolo;
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public String getTitolo() {
        return titolo;
    }

    public boolean isRiproducibile() {
        return true;
    }

    public int getDurata() {
        return durata;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            stampaTitoloConLuminosita();
        }
    }

    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

    private void stampaTitoloConLuminosita() {
        String result = getTitolo();
        for (int i = 0; i < volume; i++) {
            result += "!";
        }
        for (int i = 0; i < luminosita; i++) {
            result += "*";
        }
        System.out.println(result);
    }
}
