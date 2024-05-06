import dao.RivenditoreDAO;
import dao.TesseraDAO;
import dao.UtenteDAO;
import entity.ticket.rivenditore.DistributoreAutomatico;
import entity.ticket.rivenditore.Rivenditore;
import entity.ticket.rivenditore.RivenditoreAutorizzato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw4");
        EntityManager em = emf.createEntityManager();

        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        RivenditoreDAO rivenditoreDAO = new RivenditoreDAO(em);
//
//        Utente u1 = new Utente();
//        u1.setNome("Stefano");
//        u1.setCognome("Fortezza");
//        u1.setEmail("stefano.fortezza@epicode.it");
//        u1.setDataDiNascita(LocalDate.of(1998, 7, 28));
//        u1.setSesso(Sesso.UOMO);
//        u1.setNumeroTelefono("+3934085890692");
//
//        utenteDAO.save(u1);
//
//        Tessera t1 = new Tessera();
//        t1.setUtente(u1);
//        t1.setDataEmissione(LocalDate.now());
//        tesseraDAO.save(t1);

        DistributoreAutomatico da1 = new DistributoreAutomatico();
        da1.aggiungiDisponibilita(100);
        try {
            da1.aggiungiVendita(1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            da1.aggiungiVendita(1000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            da1.rimuoviDisponibilita(1000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            da1.rimuoviDisponibilita(10);
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }

        da1.setAttivo(false);

        rivenditoreDAO.save(da1);

        Rivenditore ra1 = new RivenditoreAutorizzato();
        ra1.aggiungiDisponibilita(100);
        try {
            ra1.aggiungiVendita(1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            ra1.aggiungiVendita(1000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            ra1.rimuoviDisponibilita(1000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            ra1.rimuoviDisponibilita(10);
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
