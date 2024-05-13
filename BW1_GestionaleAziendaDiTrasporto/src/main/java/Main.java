import dao.*;
import entity.mezzo.Mezzo;
import entity.mezzo.StatoMezzo;
import entity.ticket.Abbonamento;
import entity.ticket.Biglietto;
import entity.ticket.rivenditore.Rivenditore;
import entity.ticket.rivenditore.RivenditoreAutorizzato;
import entity.tratta.Tratta;
import entity.tratta.Viaggio;
import entity.utente.Tessera;
import enums.Autorizzazione;
import enums.TipoAbbonamento;
import enums.TipoMezzo;
import enums.TipoStatoMezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bw4");
        EntityManager em = emf.createEntityManager();

        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        RivenditoreDAO rivenditoreDAO = new RivenditoreDAO(em);
        TicketDAO ticketDAO = new TicketDAO(em);
        StatoDAO statoDAO = new StatoDAO(em);
        MezzoDAO mezzoDAO = new MezzoDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        ViaggioDAO viaggioDAO = new ViaggioDAO(em);
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

//        DistributoreAutomatico da1 = new DistributoreAutomatico();
//        da1.aggiungiDisponibilita(100);
//        try {
//            da1.aggiungiVendita(1);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        try {
//            da1.aggiungiVendita(1000);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        try {
//            da1.rimuoviDisponibilita(1000);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        try {
//            da1.rimuoviDisponibilita(10);
//        }catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        da1.setAttivo(false);
//
//        rivenditoreDAO.save(da1);

//        RivenditoreAutorizzato ra1 = new RivenditoreAutorizzato();
//        ra1.aggiungiDisponibilita(100);
//        try {
//            ra1.aggiungiVendita(1);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        try {
//            ra1.aggiungiVendita(1000);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        try {
//            ra1.rimuoviDisponibilita(1000);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        try {
//            ra1.rimuoviDisponibilita(10);
//        }catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        ra1.setAutorizzazione(Autorizzazione.REGIONE);
//        ra1.setNomeRivenditore("Chest'è");
//
//        rivenditoreDAO.save(ra1);
//        Rivenditore findRa1 = rivenditoreDAO.getById(7);
//        Rivenditore findDa1 = rivenditoreDAO.getById(5);
//        Tessera findT1 = tesseraDAO.getById(4);
//        Abbonamento ab1 = new Abbonamento();
//        ab1.setTessera(findT1);
//        ab1.setTipoAbbonamento(TipoAbbonamento.MENSILE);
//        ab1.setPrezzo(49.99);
//        try {
//            ab1.aggiungiRivenditore(findRa1);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        try {
//            ab1.setDataEmissione(LocalDate.now());
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        ticketDAO.save(ab1);
//
//        Biglietto b1 = new Biglietto();
//        b1.setPrezzo(3.99);
//        try {
//            b1.aggiungiRivenditore(findDa1);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        try {
//            b1.setDataEmissione(LocalDate.now());
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        ticketDAO.save(b1);

        // Conteggio biglietti per periodo
        Integer bigliettiDatati = ticketDAO.findTicketFromPeriod(LocalDate.of(2023, 12, 25), LocalDate.now());
        System.out.println("Biglietti creati in un periodo di tempo: "+bigliettiDatati);

        // Conteggio biglietti per Rivenditore
        HashMap<String, Integer> numTicketFromRivenditore = rivenditoreDAO.findNumTicketFromRivenditore();
        System.out.println(numTicketFromRivenditore);

        // Validità abbonamento in base a biglietto, tessera e utente
        Boolean isValid1 = ticketDAO.isValid(ticketDAO.getById(22), utenteDAO.getById(3));
        System.out.println("L'abbonamento con id 22 è di Stefano e non è scaduto? "+isValid1);
        Boolean isValid2 = ticketDAO.isValid(ticketDAO.getById(22), utenteDAO.getById(4));
        System.out.println("L'abbonamento con id 22 è di Leonardo e non è scaduto? "+isValid2);

        // Creazione mezzo
//        Mezzo m1 = new Mezzo();
//        m1.setTipoMezzo(TipoMezzo.TRAM);
//        m1.setCapienza(150);
//        mezzoDAO.save(m1);
//
//        StatoMezzo sm1 = new StatoMezzo();
//        sm1.setTipo(TipoStatoMezzo.MANUTENZIONE);
//        sm1.setInizio(LocalDateTime.of(2024, 5, 1, 13, 5));
//        sm1.setFine(LocalDateTime.of(2024, 5, 3, 9, 0));
//        sm1.setMezzo(m1);
//        statoDAO.save(sm1);
//
//        StatoMezzo sm2 = new StatoMezzo();
//        sm2.setTipo(TipoStatoMezzo.SERVIZIO);
//        sm2.setInizio(LocalDateTime.of(2024, 5, 3, 9, 1));
//        sm2.setMezzo(m1);
//        statoDAO.save(sm2);
//
//        Biglietto findb1 = (Biglietto) ticketDAO.getById(23);
//        System.out.println(findb1);
//        try {
//            findb1.setVidimazione(LocalDateTime.now(), m1);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//        ticketDAO.update(findb1);

        // Biglietti vidimati da un mezzo
        Mezzo findm2 = mezzoDAO.getById(40);
        System.out.println("Biglietti vidimati su mezzo 40: "+findm2.getBigliettiVidimati().size());

        // Biglietti vidimati in un periodo di tempo
        System.out.println("Biglietti vidimati in un periodo: "+ticketDAO.findTicketVidimatiFromPeriod(LocalDate.of(2023, 12, 25), LocalDate.now()));

        // Creazione Tratta
//        Tratta tr1 = new Tratta("Roma Tiburtina", "Napoli Centrale", Duration.ofHours(2).plusMinutes(10));
//        trattaDAO.save(tr1);
        Tratta findtr1 = trattaDAO.getById(46);
        Mezzo findm1 = mezzoDAO.getById(37);
//        Viaggio v1 = new Viaggio(LocalDateTime.now(), findtr1, findm1);
//        v1.setOrarioArrivo(LocalDateTime.now().plusHours(4));
//        viaggioDAO.save(v1);

        // Conta Numero di volte che un mezzo percorre una tratta
        System.out.println("Il mezzo 37 ha percorso la tratta 46 : "+mezzoDAO.contaTratte(findm1, findtr1)+" volte");

        // Verifica del tempo di percorrenza effettivo di un viaggio
        System.out.println("Il mezzo 37 ha effettuato un viaggio della tratta 46 in "+ durataInStringa(viaggioDAO.getById(48).getPercorrenzaEffettiva()));
    }

    public static String durataInStringa(Duration durata) {
        long secondi = durata.getSeconds();
        long ore = secondi / 3600;
        long minuti = (secondi % 3600) / 60;
        secondi = secondi % 60;
        return "H"+ore+" M"+minuti+" S"+secondi;
    }
}
