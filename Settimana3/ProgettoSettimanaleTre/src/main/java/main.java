import dao.*;
import entity.*;
import entity.Enum.Periodicità;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoSettimanaleTre");
        EntityManager em = emf.createEntityManager();

        ElementoPrestatoDao elementoPrestatoDao = new ElementoPrestatoDao(em);
        LibriDao libriDao = new LibriDao(em);
        PrestitoDao prestitoDao = new PrestitoDao(em);
        RivisteDao rivisteDao = new RivisteDao(em);
        UtenteDao utenteDao = new UtenteDao(em);

        // Creazione del libro
        Libri l1 = new Libri();
        l1.setCodiceISBN(100L);
        l1.setTitolo("Il signore degli Anelli");
        l1.setPagine(350);
        l1.setDate(LocalDate.of(2000, 5, 10));
        l1.setAutore("J. R. R. Tolkien");
        l1.setGenere("Romanzo");

        libriDao.save(l1);

        Libri l2 = new Libri();
        l2.setCodiceISBN(101L);
        l2.setTitolo("Secondo Libro");
        l2.setPagine(350);
        l2.setDate(LocalDate.of(2001, 5, 10));
        l2.setAutore("Stefano");
        l2.setGenere("Romanzo");

        libriDao.save(l2);

        // Creazione della rivista
        Riviste r1 = new Riviste();
        r1.setPeriodicità(Periodicità.MENSILE);
        r1.setCodiceISBN(1L);
        r1.setDate(LocalDate.of(2006, 1, 1));
        r1.setTitolo("Prima Stampa");
        r1.setPagine(80);

        rivisteDao.save(r1);


        Riviste r2 = new Riviste();
        r1.setPeriodicità(Periodicità.MENSILE);
        r1.setCodiceISBN(1L);
        r1.setDate(LocalDate.of(2005, 1, 1));
        r1.setTitolo("Prima Stampa");
        r1.setPagine(80);

        rivisteDao.save(r2);

        // Creazione dell'utente
        Utente u1 = new Utente();
        u1.setNome("Stefano");
        u1.setCognome("Fortezza");
        u1.setDataDiNascita(LocalDate.of(1998, 7, 28));
        u1.setNumeroDiTessera(601);

        utenteDao.save(u1);

        Utente u2 = new Utente();
        u2.setNome("Luca");
        u2.setCognome("Rossi");
        u2.setDataDiNascita(LocalDate.of(2000, 8, 20));
        u2.setNumeroDiTessera(602);

        utenteDao.save(u2);

        // Creazione del prestito
        Prestito p1 = new Prestito();
        p1.setUtente(u1);
        p1.setElementoPrestato(l1);
        p1.setDataInizioPrestito(LocalDate.of(2024, 1, 3));
        p1.setDataRestituzioneEffettiva(LocalDate.of(2024, 1, 15));
        p1.setUtente(u1);
        prestitoDao.save(p1);

        Prestito p2 = new Prestito();
        p2.setUtente(u2);
        p2.setElementoPrestato(l2);
        p2.setDataInizioPrestito(LocalDate.of(2024, 1, 3));
        p2.setDataRestituzioneEffettiva(LocalDate.of(2024, 1, 15));
        p2.setUtente(u2);
        prestitoDao.save(p2);


        // Aggiunta del prestito alla lista dei prestiti dell'utente
        List<Prestito> prestitiUtente = new ArrayList<>();
        prestitiUtente.add(p1);
        prestitiUtente.add(p2);
        u1.setPrestiti(prestitiUtente);
        u2.setPrestiti(prestitiUtente);

        // Salvataggio dell'elemento prestato associato al prestito
        elementoPrestatoDao.save(p1.getElementoPrestato());
        elementoPrestatoDao.save(p2.getElementoPrestato());

        //Rimozione di un elemento dato un codice ISBN
        //libriDao.delete(100L);

        //Ricerca per anno di pubblicazione
        List<Libri> libriStessoAnno = libriDao.getByAnnoDiPubblicazione(2001);
        for (Libri libro : libriStessoAnno) {
//            System.out.println(libro);
        }

        List<Riviste> rivisteStessoAnno = rivisteDao.getByAnnoDiPubblicazione(2005);
        for (Riviste riviste : rivisteStessoAnno) {
//            System.out.println(rivisteStessoAnno);
        }

//        libriDao.getByAutore("Stefano").forEach(System.out::println);

//        libriDao.getByTitolo("Il signore").forEach(System.out::println);

//        prestitoDao.getElementiInPrestitoByNumeroTessera(602).forEach(System.out::println);

        prestitoDao.getPrestitiScadutiNonRestituiti().forEach(System.out::println);
    }
}
