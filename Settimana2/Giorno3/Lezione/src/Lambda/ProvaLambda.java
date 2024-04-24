package Lambda;

import java.util.Comparator;
import java.util.TreeSet;

public class ProvaLambda {
    public static void main(String[] args) {
        //CREO OGGETTO COMPARATORE 1 SOLA VOLTA E LO UTILIZZO NEL COSTRUTTORE DEL TREESET
        Comparatore comparatore = new Comparatore();

        TreeSet<String> parole = new TreeSet<>(comparatore);

        parole.add("java");
        parole.add("html");
        parole.add("css");
        parole.add("javascript");

        System.out.println(parole);


    }
}
