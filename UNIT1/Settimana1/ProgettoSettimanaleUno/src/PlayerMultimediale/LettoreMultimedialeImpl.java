package PlayerMultimediale;

import java.util.Scanner;

public class LettoreMultimedialeImpl implements LettoreMultimediale {
    private ElementoMultimediale[] elementi = new ElementoMultimediale[5];

    private Scanner scanner = new Scanner(System.in);

    public void aggiungiElemento(ElementoMultimediale elemento, int indice) {
        if (indice >= 0 && indice < 5) {
            elementi[indice] = elemento;
        } else {
            System.out.println("Indice non valido!");
        }
    }

    public void eseguiElemento(int indice) {
        if (indice >= 0 && indice < 5) {
            ElementoMultimediale elemento = elementi[indice];
            if (elemento != null) {
                if (elemento instanceof Immagine) {
                    ((Immagine) elemento).show();
                } else {
                    elemento.play();
                }
            } else {
                System.out.println("Elemento non trovato!");
            }
        } else {
            System.out.println("Indice non valido!");
        }
    }
}
