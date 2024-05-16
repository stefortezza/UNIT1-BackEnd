package it.epicode.Esercizio;

import it.epicode.Esercizio.appConfig.AppConfig;
import it.epicode.Esercizio.bean.Menu;
import it.epicode.Esercizio.bean.Ordine;
import it.epicode.Esercizio.bean.Tavolo;
import it.epicode.Esercizio.enums.StatoOrdine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EsercizioOrdineRistoranteApplication.class);

        Menu menu = ctx.getBean(Menu.class);

        menu.stampaMenu();

        Tavolo tavolo1 = ctx.getBean("tavolo1", Tavolo.class);

        System.out.println();
        Ordine ordine1 = new Ordine(5, tavolo1);

        ordine1.setNumeroOrdine(1);
        ordine1.setDataAcquisizione(LocalDateTime.now());
        ordine1.setStatoOrdine(StatoOrdine.IN_CORSO);
        ordine1.setBevande(List.of(menu.getBevande().get(0), menu.getBevande().get(1)));
        ordine1.setIngredienti(List.of(menu.getIngredienti().get(0), menu.getIngredienti().get(1)));
        ordine1.setPizze(List.of(menu.getPizze().get(0), menu.getPizze().get(0), menu.getPizze().get(1), menu.getPizze().get(1)));

        ordine1.stampaOrdine();

    }
}
