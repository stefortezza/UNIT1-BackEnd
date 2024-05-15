package it.epicode.Lezione;

import it.epicode.Lezione.bean.Aula;
import it.epicode.Lezione.bean.Dispositivo;
import it.epicode.Lezione.bean.Scuola;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println();
//accediamo al contesto di Spring
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LezioneApplication.class);

        Aula aula = ctx.getBean(Aula.class);
        System.out.println(aula);

        System.out.println();

        Dispositivo dispositivo = ctx.getBean("smartphone", Dispositivo.class);
        Dispositivo dispositivo2 = ctx.getBean("computer", Dispositivo.class);
        System.out.println(dispositivo);
        System.out.println(dispositivo2);

        System.out.println();

        Scuola scuola = ctx.getBean(Scuola.class);
        System.out.println(scuola);
    }
}
