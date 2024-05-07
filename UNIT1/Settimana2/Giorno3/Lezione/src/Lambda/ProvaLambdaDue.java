package Lambda;

import java.util.Comparator;
import java.util.TreeSet;

public class ProvaLambdaDue {

    public static void main(String[] args) {

        //UTILIZZIAMO UNA CLASSE ANONIMA PER DEFINIRE IL COMPARE SENZA CREARE UNA CLASSE A PARTE
        //E OGGETTI DELLA CLASSE COMPARATORE
        TreeSet<String> parole = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        parole.add("java");
        parole.add("html");
        parole.add("css");
        parole.add("javascript");

        System.out.println(parole);
    }
}
