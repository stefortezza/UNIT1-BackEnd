package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.bean.Edificio;
import it.epicode.GestionePrenotazioni.bean.Prenotazione;
import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.enums.TipoPostazione;
import it.epicode.GestionePrenotazioni.repository.EdificioRepository;
import it.epicode.GestionePrenotazioni.service.EdificioService;
import it.epicode.GestionePrenotazioni.service.PrenotazioneService;
import it.epicode.GestionePrenotazioni.service.UtenteService;
import it.epicode.GestionePrenotazioni.service.PostazioneAziendaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioneAziendaleService postazioneAziendaleService;

    @Autowired
    private PrenotazioneService prenotazioneService;


    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);
        Edificio edificio = (Edificio) ctx.getBean("edificio1");
        edificioService.inserisciEdificio(edificio);
        PostazioneAziendale postazione1 = null;
        try {
            Edificio edificio1 = edificioService.getEdificio(1);
            postazione1 = new PostazioneAziendale();
            postazione1.setCodiceUnivoco(1);
            postazione1.setEdificio(edificio1);
            postazione1.setTipoPostazione(TipoPostazione.PRIVATO);
            postazione1.setNumeroMassimoOccupanti(1);
            postazione1.setDescrizione("Postazione n°1");
            postazioneAziendaleService.InserisciPostazioneAziendale(postazione1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        PostazioneAziendale postazione2 = null;
        try {
            Edificio edificio1 = edificioService.getEdificio(1);
            postazione2 = new PostazioneAziendale();
            postazione2.setCodiceUnivoco(2);
            postazione2.setEdificio(edificio1);
            postazione2.setTipoPostazione(TipoPostazione.PRIVATO);
            postazione2.setNumeroMassimoOccupanti(5);
            postazione2.setDescrizione("Postazione n°2");
            postazioneAziendaleService.InserisciPostazioneAziendale(postazione2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Utente utente1 = new Utente();
        utente1.setUsername("stefortezza");
        utente1.setEmail("stefano@fortezza.com");
        utente1.setNome("Stefano Fortezza");
        utenteService.inserisciUtente(utente1);

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setId(1);
        prenotazione1.setGiornoPrenotato(LocalDate.now());
        prenotazione1.setUtente(utente1);
        prenotazione1.setPostazioneAziendale(postazione1);
        prenotazioneService.prenotaPostazione("stefortezza", 1, LocalDate.now());

        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setId(2);
        prenotazione2.setGiornoPrenotato(LocalDate.now());
        prenotazione2.setUtente(utente1);
        prenotazione2.setPostazioneAziendale(postazione2);
        prenotazioneService.prenotaPostazione("stefortezza", 1, LocalDate.now());

        System.out.println(postazioneAziendaleService.getPostazioneAziendaleAll());
        System.out.println(utenteService.getUtenteAll());
    }
}
