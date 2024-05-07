package PlayerMultimediale;

public class Audio implements ElementoMultimediale {

    private String titolo;
    private int durata;
    private int volume;

    public Audio(String titolo, int durata, int volume) {
        this.titolo = titolo;
        this.durata = durata;
        this.volume = volume;
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
            stampaConVolume();
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


    private void stampaConVolume() {
        String result = getTitolo();
        for (int i = 0; i < volume; i++) {
            result += "!";
        }
        System.out.println(result);
    }
}




