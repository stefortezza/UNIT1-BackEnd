package epicode;

import epicode.dao.GestioneEventiDao;
import epicode.dao.LocationDao;
import epicode.dao.PartecipazioneDao;
import epicode.dao.PersonaDao;
import epicode.entity.Concerto;
import epicode.entity.GaraDiAtletica.PartitaDiCalcio;
import epicode.entity.Genere;
import epicode.entity.gestioneEventi.GestioneEventi;
import epicode.entity.gestioneEventi.TipoEvento;
import epicode.entity.location.Location;
import epicode.entity.partecipazione.Partecipazione;
import epicode.entity.partecipazione.Stato;
import epicode.entity.persona.Persona;
import epicode.entity.persona.Sesso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi3");
        EntityManager em = emf.createEntityManager();

        GestioneEventiDao eventiDao = new GestioneEventiDao(em);
        PersonaDao personaDao = new PersonaDao(em);
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao(em);
        LocationDao locationDao = new LocationDao(em);

//        //AGGIUNTA DI UN EVENTO
//        GestioneEventi e1 = new GestioneEventi();
//        e1.setTitolo("Festa del 1 Maggio");
//        e1.setDataEvento(LocalDate.of(2024, 05, 01));
//        e1.setDescrizione("Festa dei lavoratori");
//        e1.setTipoEvento(TipoEvento.PUBBLICO);
//        e1.setNumeroMassimoPartecipanti(500);
//
//        eventiDao.save(e1);
//
//        //AGGIUNTA DI UNA LOCATION
//        Location location = new Location();
//        location.setNome("Circo Massimo");
//        location.setCitta("Roma");
//
//        locationDao.save(location);
//
//        e1.setLocation(location);
//        eventiDao.save(e1);
//
//        //AGGIUNTA DI UNA PERSONA
//        Persona p1 = new Persona();
//        p1.setNome("Stefano");
//        p1.setCognome("Fortezza");
//        p1.setEmail("stefano@fortezza.it");
//        p1.setDataDiNascita(LocalDate.of(1998, 07, 28));
//        p1.setSesso(Sesso.MASCHIO);
//
//        personaDao.save(p1);
//
//        Persona p2 = new Persona();
//        p2.setNome("Luca");
//        p2.setCognome("Rossi");
//        p2.setEmail("luca@rossi.it");
//        p2.setDataDiNascita(LocalDate.of(2000, 03, 05));
//        p2.setSesso(Sesso.MASCHIO);
//
//        personaDao.save(p2);
//
//        Partecipazione partecipazione = new Partecipazione();
//        partecipazione.setEvento(e1);
//        partecipazione.setPersona(p1);
//        partecipazione.setStato(Stato.DA_CONFERMARE);
//
//        partecipazioneDao.save(partecipazione);
//
//        Partecipazione partecipazione2 = new Partecipazione();
//        partecipazione2.setEvento(e1);
//        partecipazione2.setPersona(p2);
//        partecipazione2.setStato(Stato.DA_CONFERMARE);
//
//        partecipazioneDao.save(partecipazione2);

        //RICERCA PERSONA IN BASE AL NOME
        personaDao.getPersonaByName("Stefano").forEach(System.out::println);
        //RICERCA PERSONA IN BASE AL COGNOME
        personaDao.getPersonaByCognome("Verdi").forEach(System.out::println);

        System.out.println();

        GestioneEventi gestioneEventi = eventiDao.getById(20);
        partecipazioneDao.getPersonaByEvento(gestioneEventi).forEach(System.out::println);
        System.out.println();

        System.out.println(partecipazioneDao.countPersonaByEvento(gestioneEventi));
        System.out.println();

        personaDao.getPersonaByPartName("o").forEach(System.out::println);

        PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio();
        partitaDiCalcio.setSquadraCasa("Inter");
        partitaDiCalcio.setSquadraOspite("Salernitana");
        partitaDiCalcio.setSquadraVincente("Salernitana");
        partitaDiCalcio.setGoalCasa(1);
        partitaDiCalcio.setGoalOspite(3);
        partitaDiCalcio.setDescrizione("Inter vs Salernitana");
        partitaDiCalcio.setTitolo("Partita");
        partitaDiCalcio.setNumeroMassimoPartecipanti(80000);
        partitaDiCalcio.setDataEvento(LocalDate.of(2026, 5, 6));

        eventiDao.save(partitaDiCalcio);

        Concerto concerto = new Concerto();
        concerto.setTitolo("Concerto");
        concerto.setGenere(Genere.POP);
        concerto.setInStreaming(false);
        concerto.setDescrizione("Concerto di Harry Style");
        concerto.setDataEvento(LocalDate.of(2025, 05,1));
        concerto.setNumeroMassimoPartecipanti(20000);
        concerto.setTipoEvento(TipoEvento.PUBBLICO);

        eventiDao.save(concerto);

        Query query = em.createQuery("select c from Concerto c where c.inStreaming= :inStreaming");

        Query query2 = em.createQuery("select c from Concerto c where c.genere= :genere");

        Query query3 = em.createQuery("select p from PartitaDiCalcio p where p.goalCasa > p.goalOspite");

        Query query4 = em.createQuery("select g from GaraDiAtletica g where g.vincitore= :persona");


    }
}
