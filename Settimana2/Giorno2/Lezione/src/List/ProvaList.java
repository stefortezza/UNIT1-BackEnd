package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProvaList {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>(); //<Objects> posso inserire qualsiasi cosa in questo modo
        //però non posso chiaamare il metodo .get()!!
        lista.add("5"); //SI UTILIZZA IL .ADD PER AGGIUNGERE ELEMENTI ALL'ARRAY!!
        lista.add("Stefano Fortezza");
        lista.add("true");

        lista.get(0);
        System.out.println(lista.get(1));

        lista.set(2, "JAVA"); //SOSTITUISCE L'ELEMENTO DI QUELLA POSIZIONE.
        // IN QUESTO CASO SOSTITUISCE L'IDICE 2 (lista.add("true");)  CON LA STRINGA JAVA

        System.out.println(lista.get(2));

        System.out.println(lista.size()); //IN QUESTO MODO IN LISTA.SIZE() MI DA QUANTI ELEMENTI CI SONO ALL'INTERNO DELL'ARRAY

//        lista.clear(); //SVUOTA COMPLETAMENTE LA LISTA

        lista.remove(0); //RIMUOVE UN ELEMENTO DALLA LISTA, PASSANDOCI L'IDICE!

        System.out.println(lista.size());

        lista.remove("JAVA"); //IN QUESTO MODO ELIMINA TUTTE LE STRINGE JAVA, ANCHE SE SONO PRESENTI
        // IN PIU' OGGETTI, LUI LE ELIMINA DA TUTTI GLI OGGETTI.

        lista.isEmpty();

//         lista.contains("Stefano"); //CONTROLLA SE UN ELEMENTO E' PRESENTE O MENO ALL'INTERNO DI UNA LISTA!
        //RESTITUISCE TRUE SE LO TROVA, FALSE ALTRIMENTI!

        System.out.println(lista.contains("Stefano Fortezza"));

        System.out.println(lista.indexOf("Stefano")); //RESTITUISCE IN QUALE INDICE DI UN OGGETTO STA ALL'INTERNO DELLA LISTA!

        lista.add("css");
        lista.add("javascript");
        lista.add("python");
        lista.add("javascript");

        System.out.println(lista);

        lista.removeAll(List.of("java", "javascript", "html")); //CREAZIONE DI UN'ARRAY IN MANIERA VELOCE, E LA LORO RIMOZIONE

        System.out.println(lista);

        for (String s : lista) {
            System.out.println(s);
        }

        LinkedList<String> lista2 = new LinkedList<>(); //LA DIFF. E' CHE IMPLEMENTA QUELLA QIUE.

        lista2.poll(); //possiaimo prendere un elemento in testa alla lista

    }
}
