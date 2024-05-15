package it.epicode.Esercizio;

import it.epicode.Esercizio.appConfig.AppConfig;
import it.epicode.Esercizio.bean.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Menu menu = ctx.getBean(Menu.class);

        menu.stampaMenu();
    }
}
