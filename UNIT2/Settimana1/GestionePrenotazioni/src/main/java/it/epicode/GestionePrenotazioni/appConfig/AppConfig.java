package it.epicode.GestionePrenotazioni.appConfig;

import it.epicode.GestionePrenotazioni.bean.Edificio;
import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.enums.DisponibilitaPostazione;
import it.epicode.GestionePrenotazioni.enums.TipoPostazione;
import it.epicode.GestionePrenotazioni.service.EdificioService;
import it.epicode.GestionePrenotazioni.service.PostazioneAziendaleService;
import it.epicode.GestionePrenotazioni.service.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.util.Objects;

@Configuration
public class AppConfig {

    @Bean("Utente_Stefano")
    @Primary
    public Utente getUtente1() {
        Utente utente1 = new Utente();
        utente1.setUsername("stefortezza");
        utente1.setNome("Stefano Fortezza");
        utente1.setEmail("stefano@fortezza.it");
        return utente1;
    }

    @Bean("Utente_Mario")
    public Utente getUtente2() {
        Utente utente2 = new Utente();
        utente2.setUsername("marioRossi");
        utente2.setNome("Mario Rossi");
        utente2.setEmail("mario@rossi.it");
        return utente2;
    }

    @Bean("Utente_Luca")
    public Utente getUtente3() {
        Utente utente3 = new Utente();
        utente3.setUsername("lucaVerdi");
        utente3.setNome("Luca Verdi");
        utente3.setEmail("luca@verdi.it");
        return utente3;
    }

    @Bean("Postazione_A1")
    public PostazioneAziendale getPostazioneAziendale(Edificio edificio, Utente utente) {
        PostazioneAziendale postazioneAziendaleA1 = new PostazioneAziendale();
        postazioneAziendaleA1.setCodiceUnivoco(1);
        postazioneAziendaleA1.setDescrizione("Postazione Linguaggio Java");
        postazioneAziendaleA1.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazioneAziendaleA1.setNumeroMassimoOccupanti(1);
        postazioneAziendaleA1.setGiornoPrenotato(LocalDate.now());
        postazioneAziendaleA1.setDisponibilitaPostazione(DisponibilitaPostazione.LIBERO);
        postazioneAziendaleA1.setEdificio(edificio);
        postazioneAziendaleA1.setUtente(getUtente1());

        checkAndAssignUser(postazioneAziendaleA1, utente);

        return postazioneAziendaleA1;
    }

    @Bean("Postazione_B1")
    public PostazioneAziendale getSecondaPostazioneAziendale(Edificio edificio, Utente utente) {
        PostazioneAziendale postazioneAziendaleB1 = new PostazioneAziendale();
        postazioneAziendaleB1.setCodiceUnivoco(2);
        postazioneAziendaleB1.setDescrizione("Postazione Linguaggio Python");
        postazioneAziendaleB1.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazioneAziendaleB1.setNumeroMassimoOccupanti(1);
        postazioneAziendaleB1.setGiornoPrenotato(LocalDate.of(2024, 5, 30));
        postazioneAziendaleB1.setDisponibilitaPostazione(DisponibilitaPostazione.LIBERO);
        postazioneAziendaleB1.setEdificio(edificio);
        postazioneAziendaleB1.setUtente(getUtente1());

        checkAndAssignUser(postazioneAziendaleB1, utente);

        return postazioneAziendaleB1;
    }

    @Bean("Postazione_C1")
    public PostazioneAziendale getTerzaPostazioneAziendale(Edificio edificio, Utente utente) {
        PostazioneAziendale postazioneAziendaleC1 = new PostazioneAziendale();
        postazioneAziendaleC1.setCodiceUnivoco(2);
        postazioneAziendaleC1.setDescrizione("Postazione Linguaggio HTML");
        postazioneAziendaleC1.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazioneAziendaleC1.setNumeroMassimoOccupanti(1);
        postazioneAziendaleC1.setGiornoPrenotato(LocalDate.of(2024, 5, 30));
        postazioneAziendaleC1.setDisponibilitaPostazione(DisponibilitaPostazione.LIBERO);
        postazioneAziendaleC1.setEdificio(edificio);
        postazioneAziendaleC1.setUtente(getUtente3());

        checkAndAssignUser(postazioneAziendaleC1, getUtente3());

        return postazioneAziendaleC1;
    }

    public void checkAndAssignUser(PostazioneAziendale postazione, Utente utente) {
        if (postazione.getDisponibilitaPostazione() == DisponibilitaPostazione.LIBERO) {
            postazione.setUtente(utente);
            postazione.setDisponibilitaPostazione(DisponibilitaPostazione.OCCUPATO);
        } else if (postazione.getDisponibilitaPostazione() == DisponibilitaPostazione.OCCUPATO) {
            System.out.println("La postazione è già occupata.");
        } else {
            System.out.println("La postazione è già prenotata.");
        }
    }


    @Bean("Edificio_AlaA")
    public Edificio getEdificio() {
        Edificio edificio1 = new Edificio();
        edificio1.setNome("Edificio ALA A");
        edificio1.setIndirizzo("Via Roma,1");
        edificio1.setCitta("Caltagirone");
        return edificio1;
    }

    @Bean
    public CommandLineRunner initData(UtenteService utenteService, PostazioneAziendaleService postazioneAziendaleService, EdificioService edificioService) {
        return args -> {
            Edificio edificio = getEdificio();
            edificioService.inserisciEdificio(edificio);

            Utente utente = getUtente1();
            utenteService.inserisciUtente(utente);

            Utente utente2 = getUtente2();
            utenteService.inserisciUtente(utente2);

            Utente utente3 = getUtente3();
            utenteService.inserisciUtente(utente3);

            PostazioneAziendale postazioneAziendale1 = getPostazioneAziendale(edificio, utente);
            postazioneAziendaleService.InserisciPostazioneAziendale(postazioneAziendale1);

            PostazioneAziendale postazioneAziendale2 = getSecondaPostazioneAziendale(edificio, utente);
            postazioneAziendaleService.InserisciPostazioneAziendale(postazioneAziendale2);

            PostazioneAziendale postazioneAziendale3 = getTerzaPostazioneAziendale(edificio, utente3);
            postazioneAziendaleService.InserisciPostazioneAziendale(postazioneAziendale3);

            checkAndAssignUser(postazioneAziendale1, utente);
            checkAndAssignUser(postazioneAziendale2, utente);
            checkAndAssignUser(postazioneAziendale3, utente3);

        };
    }
}
