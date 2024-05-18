package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.appConfig.AppConfig;
import it.epicode.GestionePrenotazioni.enums.TipoPostazione;
import it.epicode.GestionePrenotazioni.service.EdificioService;
import it.epicode.GestionePrenotazioni.service.UtenteService;
import it.epicode.GestionePrenotazioni.service.PostazioneAziendaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioneAziendaleService postazioneAziendaleService;

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);


//        System.out.println(utenteService.getUtenteByPartialNome("%S%"));
//        System.out.println(utenteService.getUtenteByPartialNome("%M%"));
//        System.out.println(edificioService.getEdificioAll());
//        System.out.println(postazioneAziendaleService.getPostazioneAziendaleAll());
        System.out.println(postazioneAziendaleService.getPostazioneAziendaleByCodiceUnivoco(1));
    }
}
