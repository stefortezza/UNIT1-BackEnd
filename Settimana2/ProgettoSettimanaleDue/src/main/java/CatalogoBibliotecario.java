import java.util.*;

public class CatalogoBibliotecario {
    public static void main(String[] args) {
        Libri libro1 = new Libri(1L, "libro 1", 2024, 365, "mario rossi", "romantico");
        Libri libro2 = new Libri(2L, "libro 2", 2020, 534, "francesco bianchi", "drammatico");
        Libri libro3 = new Libri(3L, "libro 3", 2004, 434, "luca verdi", "horror");

        List<Libri> libro = new ArrayList<>();
        libro.add(libro1);
        libro.add(libro2);
        libro.add(libro3);

        Riviste rivista1 = new Riviste(10L, "Rivista 1", 2024, 186, Periodicità.MENSILE);
        Riviste rivista2 = new Riviste(11L, "Rivista 2", 2000, 245, Periodicità.SETTIMANALE);
        Riviste rivista3 = new Riviste(12L, "Rivista 3", 2001, 177, Periodicità.SEMESTRALE);

        List<Riviste> riviste = new ArrayList<>();
        riviste.add(rivista1);
        riviste.add(rivista2);
        riviste.add(rivista3);

        //METODO PER AGGIUNGERE O UN LIBRO O UNA RIVISTA!!
        System.out.println("Aggiunta di un'elemento: ");
        Libri nuovoLibro = new Libri(4L, "libro 4", 2022, 300, "Giovanni Verdi", "fantascienza");
        libro.add(nuovoLibro);
        System.out.println(nuovoLibro);

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
        System.out.println("RICERCA DI UN LIBRO: ");
        Libri ricercaTramiteIsbn = libro.stream()
                .filter(libri -> libri.getCodiceISBN().equals(1L))
                .findFirst()
                .orElse(null);
        System.out.println(ricercaTramiteIsbn);
    }
}
