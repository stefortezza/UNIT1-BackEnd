package it.epicode.Lezione;

import it.epicode.Lezione.appConfig.AppConfig;
import it.epicode.Lezione.bean.Aula;
import it.epicode.Lezione.bean.Dispositivo;
import it.epicode.Lezione.bean.Scuola;
import it.epicode.Lezione.bean.Studente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LezioneApplication {

    public static void main(String[] args) {
        SpringApplication.run(LezioneApplication.class, args);
    }
}
