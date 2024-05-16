package it.epicode.Lezione;

import it.epicode.Lezione.bean.Computer;
import it.epicode.Lezione.bean.Smartphone;
import it.epicode.Lezione.bean.Studente;
import it.epicode.Lezione.service.DispositivoService;
import it.epicode.Lezione.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private StudenteService studenteService;
    @Autowired
    private DispositivoService dispositivoService;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LezioneApplication.class);

//        Studente studente1 = ctx.getBean("Carla", Studente.class);
//        studenteService.InserisciStudente(studente1);
//
//        Studente studente2 = ctx.getBean("Luca", Studente.class);
//        studenteService.InserisciStudente(studente2);
//
//        Studente studente3 = new Studente();
//        studente3.setCognome("Fortezza");
//        studente3.setNome("Stefano");
//        studente3.setMatricola(10);
//        studente3.setIndirizzo("Via Roma, 1");
//        studenteService.InserisciStudente(studente3);
//
//        Computer computer = ctx.getBean(Computer.class);
//        computer.setStudente(studente1);
//        dispositivoService.InserisciDispositivo(computer);
//
//        Smartphone smartphone = ctx.getBean(Smartphone.class);
//        smartphone.setStudente(studente2);
//        dispositivoService.InserisciDispositivo(smartphone);
//
//        Smartphone smartphone1 = ctx.getBean(Smartphone.class);
//        smartphone1.setStudente(studente3);
//        dispositivoService.InserisciDispositivo(smartphone);

        System.out.println(studenteService.getStudentiByNome("Carla"));
        System.out.println(studenteService.getStudentiByPartialNome("%S%"));
        System.out.println(dispositivoService.getComputerByRamLessThan(8));
        System.out.println(dispositivoService.getDispositivoOrderByNome());
    }
}
