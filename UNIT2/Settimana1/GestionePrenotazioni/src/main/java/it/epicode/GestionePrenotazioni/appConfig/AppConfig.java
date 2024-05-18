package it.epicode.GestionePrenotazioni.appConfig;

import it.epicode.GestionePrenotazioni.bean.Edificio;
import it.epicode.GestionePrenotazioni.bean.PostazioneAziendale;
import it.epicode.GestionePrenotazioni.bean.Utente;
import it.epicode.GestionePrenotazioni.enums.DisponibilitaPostazione;
import it.epicode.GestionePrenotazioni.enums.TipoPostazione;
import it.epicode.GestionePrenotazioni.service.EdificioService;
import it.epicode.GestionePrenotazioni.service.PostazioneAziendaleService;
import it.epicode.GestionePrenotazioni.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;

@Configuration
public class AppConfig {

    @Bean("Utente_Stefano")
    @Primary
    public Utente getUtente() {
        Utente utente1 = new Utente();
        utente1.setUsername("stefortezza");
        utente1.setNome("Stefano");
        utente1.setEmail("stefano@fortezza.it");
        return utente1;
    }

    @Bean("Utente_Mario")
    public Utente getUtente2() {
        Utente utente2 = new Utente();
        utente2.setUsername("marioRossi");
        utente2.setNome("Mario");
        utente2.setEmail("mario@rossi.it");
        return utente2;
    }

    @Bean("Postazione_A1")
    public PostazioneAziendale getPostazioneAziendale(Edificio edificio, Utente utente) {
        PostazioneAziendale postazioneAziendaleA1 = new PostazioneAziendale();
        postazioneAziendaleA1.setCodiceUnivoco(1);
        postazioneAziendaleA1.setDescrizione("Postazione Linguaggio Java");
        postazioneAziendaleA1.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazioneAziendaleA1.setNumeroMassimoOccupanti(5);
        postazioneAziendaleA1.setGiornoPrenotato(LocalDate.now());
        postazioneAziendaleA1.setDisponibilitaPostazione(DisponibilitaPostazione.LIBERO);
        postazioneAziendaleA1.setEdificio(edificio);
        postazioneAziendaleA1.setUtente(getUtente());
        return postazioneAziendaleA1;
    }

    @Bean("Postazione_B1")
    public PostazioneAziendale getSecondaPostazioneAziendale(Edificio edificio, @Qualifier("Utente_Mario") Utente utente) {
        PostazioneAziendale postazioneAziendaleB1 = new PostazioneAziendale();
        postazioneAziendaleB1.setCodiceUnivoco(2);
        postazioneAziendaleB1.setDescrizione("Postazione Linguaggio Python");
        postazioneAziendaleB1.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazioneAziendaleB1.setNumeroMassimoOccupanti(4);
        postazioneAziendaleB1.setGiornoPrenotato(LocalDate.now());
        postazioneAziendaleB1.setDisponibilitaPostazione(DisponibilitaPostazione.LIBERO);
        postazioneAziendaleB1.setEdificio(edificio);

        checkAndAssignUser(postazioneAziendaleB1, utente);

        return postazioneAziendaleB1;
    }

    private void checkAndAssignUser(PostazioneAziendale postazione, Utente utente) {
        if (postazione.getDisponibilitaPostazione() == DisponibilitaPostazione.OCCUPATO) {
            System.out.println("La postazione è occupata e non può essere associata ad un utente.");
        } else {
            postazione.setUtente(utente);
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

            Utente utente = getUtente();
            utenteService.inserisciUtente(utente);

            Utente utente2 = getUtente2();
            utenteService.inserisciUtente(utente2);

            PostazioneAziendale postazioneAziendale1 = getPostazioneAziendale(edificio, utente);
            postazioneAziendaleService.InserisciPostazioneAziendale(postazioneAziendale1);

            PostazioneAziendale postazioneAziendale2 = getSecondaPostazioneAziendale(edificio, utente2);
            postazioneAziendaleService.InserisciPostazioneAziendale(postazioneAziendale2);
        };
    }
}
