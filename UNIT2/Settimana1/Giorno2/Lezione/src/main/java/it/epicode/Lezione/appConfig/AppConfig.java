package it.epicode.Lezione.appConfig;

import it.epicode.Lezione.bean.Aula;
import it.epicode.Lezione.bean.Computer;
import it.epicode.Lezione.bean.Smartphone;
import it.epicode.Lezione.bean.Studente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.List;

//FONDAMDENALE INSERIRLO
@Configuration
public class AppConfig {

    //FONDAMDENALE INSERIRLO, INSERIRE IL NOME PER POTERLO RICHIAMARLO AL MAIN
    //E` POSSIBILE INSERE QUALSIASI COSA, BASTA CHE NEL MAIN POI RICHIAMO QUELLO CHE
    //METTO TRA GLI APICI ""
    //@Bean("Stefano")
    //SE NON GLI PASSO IL NOME, POSSO METTERE @Primary PER FAR CAPIRE A SPRING
    //CHE DEVE DARMI QUEL TIPO ANNOTATO CON PRIMARY
    @Bean ("Carla")
    @Primary
    //@Scope("prototype")
    public Studente getStudente(@Value("${studente1.nome}") String nome, @Value("${studente1.cognome}") String cognome) {
        Studente studente = new Studente();
        studente.setNome(nome);
        studente.setCognome(cognome);
        studente.setIndirizzo("Via Roma");
        studente.setDispositivi(List.of(getComputer(), getSmartphone()));
        return studente;
    }

    @Bean("Luca")
    public Studente getStudente2() {
        Studente studente = new Studente();
        studente.setNome("Luca");
        studente.setCognome("Rossi");
        studente.setIndirizzo("Viale Europa");
        return studente;
    }

    @Bean ("computer")
    //@Primary
    public Computer getComputer() {
        Computer computer = new Computer();
        computer.setNome("G16");
        computer.setMarca("DELL");
        computer.setCpu("Intel");
        computer.setRam(16);
        computer.setMonitor(27);
        return computer;
    }

    @Bean ("smartphone")
    public Smartphone getSmartphone() {
        Smartphone smartphone = new Smartphone();
        smartphone.setNome("S23");
        smartphone.setMarca("Samsung");
        smartphone.setSchermo(6);
        return smartphone;
    }

    //@Bean
//    public Aula getAula() {
//        Aula aula = new Aula();
//        aula.setNome("FS0124");
//        aula.setStudenti(List.of(getStudente(), getStudente2()));
//        return aula;
//    }
}
