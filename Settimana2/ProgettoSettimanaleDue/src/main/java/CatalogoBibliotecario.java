import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class CatalogoBibliotecario {
    public static void main(String[] args) {
        Libri libro1 = new Libri(1L, "libro 1", 2024, 365, "mario rossi", "romantico");
        Libri libro2 = new Libri(2L, "libro 2", 2002, 534, "luca verdi", "drammatico");
        Libri libro3 = new Libri(3L, "libro 3", 2004, 434, "luca verdi", "horror");

        List<Libri> libro = new ArrayList<>();
        libro.add(libro1);
        libro.add(libro2);
        libro.add(libro3);

        Riviste rivista1 = new Riviste(10L, "Rivista 1", 2024, 186, Periodicità.MENSILE);
        Riviste rivista2 = new Riviste(11L, "Rivista 2", 2004, 245, Periodicità.SETTIMANALE);
        Riviste rivista3 = new Riviste(12L, "Rivista 3", 2001, 177, Periodicità.SEMESTRALE);

        List<Riviste> riviste = new ArrayList<>();
        riviste.add(rivista1);
        riviste.add(rivista2);
        riviste.add(rivista3);

        //METODO PER AGGIUNGERE O UN LIBRO O UNA RIVISTA!!
        System.out.println("Aggiunta di un'elemento: ");
        Libri nuovoLibro = new Libri(4L, "libro 4", 2022, 300, "giovanni verdi", "fantascienza");
        libro.add(nuovoLibro);
        Libri nuovoLibro2 = new Libri(4L, "libro 5", 2004, 564, "giovanni verdi", "storia");
        libro.add(nuovoLibro2);
        System.out.println(nuovoLibro2);

        //ELIMINAZIONE DI UN LIBRO IN BASE AL SUO CODICE ISBN!!
        System.out.println("Eliminazione del LIBRO in base al codice ISBN: ");
        libro.removeIf(libri -> libri.getCodiceISBN() == 1L);
        for (Libri libri : libro) {
            System.out.println(libri);
        }

        //ELIMINAZIONE DI UNA RIVISTA IN BASE AL SUO CODICE ISBN!!
        System.out.println("Eliminazione della RIVISTA in base al codice ISBN: ");
        riviste.removeIf(rivista -> rivista.getCodiceISBN() == 10L);
        for (Riviste rivista : riviste) {
            System.out.println(rivista);
        }

        //RICERCA DI UN LIBRO IN BASE AL SUO CODICE ISBN!!
        System.out.println("RICERCA DI UN LIBRO TRAMITE ISBN: ");
        Libri ricercaTramiteIsbn = libro.stream()
                .filter(libri -> libri.getCodiceISBN().equals(3L))
                .findFirst()
                .orElse(null);
        System.out.println(ricercaTramiteIsbn);

        //RICERCA DI UN LIBRO IN BASE ALL'ANNO DI PUBBLICAZIONE!!
        System.out.println("RICERCA DI UN LIBRO TRAMITE ANNO DI PUBBLICAZIONE: ");
        libro.stream()
                .filter(libri -> libri.getDate() == 2004)
                .forEach(System.out::println);


        //RICERCA DI UN LIBRO IN BASE AL SUO AUTORE!!
        System.out.println("RICERCA DI UN LIBRO TRAMITE AUTORE: ");
        libro.stream()
                .filter(libri -> libri.getAutore().startsWith("giovani")) //RICERCA DELL'AUTORE SOLO TRAMITE NOME
                .forEach(System.out::println);
        System.out.println();

        String prodottiSting = libro.stream()
                .map(libri ->
                        "ISBN: " + libri.getCodiceISBN()
                                + ", Titolo: " + libri.getTitolo()
                                + ", Anno di pubblicazione: " + libri.getDate()
                                + ", Pagine: " + libri.getPagine()
                                + ", Autore: " + libri.getAutore()
                                + ", Genere: " + libri.getGenere())
                .collect(Collectors.joining("#"));
        System.out.println(prodottiSting);


        File file = new File("./persistence/catalogo.txt");

        try {
            FileUtils.writeStringToFile(file, prodottiSting, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            String str = FileUtils.readFileToString(file, Charset.defaultCharset());
            String[] libroStr = str.split("#");
            Arrays.stream(libroStr).forEach(s -> System.out.println(s));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
