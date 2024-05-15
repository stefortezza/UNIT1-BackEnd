package it.epicode.Lezione;

import it.epicode.Lezione.bean.Aula;
import it.epicode.Lezione.bean.Studente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class LezioneApplicationTests {

    static ApplicationContext ctx;

    @BeforeAll
    public static void accediAlContesto() {
        ctx = new AnnotationConfigApplicationContext(LezioneApplication.class);
        System.out.println("Accesso al contesto avvenuto correttamente");
    }

    @Test
    void verificaNomePrimoStudente() {
        Studente s1 = ctx.getBean("Carla", Studente.class);
        Assertions.assertEquals("Carla", s1.getNome());
    }

    @Test
    public void verificaAulaNotNull() {
        Aula a1 = ctx.getBean(Aula.class);
        Assertions.assertNotNull(a1);
    }

    @Test
    public void verificaNumeroStudentiInAula() {
        Aula a2 = ctx.getBean(Aula.class);
        Assertions.assertEquals(2, a2.getStudenti().size());
    }

    @ParameterizedTest //testo parametrizzato che viene ripetuto tante volte quante sono le stringe nell`array
    @ValueSource(strings = {"C"})
    public void verificaNumeroStudentiConNomeCheIniziaCon(String inizio) {
        Aula aula = ctx.getBean(Aula.class);
        aula.getStudenti()
                .stream()
                .filter(studente -> studente.getNome().startsWith(inizio)).forEach(System.out::println);
        Long numero = aula.getStudenti()
                .stream()
                .filter(studente -> studente.getNome().startsWith(inizio)).count();
        Assertions.assertEquals(1, numero);
    }

    @ParameterizedTest
    @CsvSource({"C,1", "F,1"})
    public void verificaNumeroStudentiConNomeCheIniziaCon (String inizio, long conteggio) {
        Aula aula = ctx.getBean(Aula.class);
        aula.getStudenti()
                .stream()
                .filter(studente -> studente.getNome().startsWith(inizio)).forEach(System.out::println);
        Long numero = aula.getStudenti()
                .stream()
                .filter(studente -> studente.getNome().startsWith(inizio)).count();
        Assertions.assertEquals(conteggio, numero);

    }

    @AfterAll
    public static void chiudiContesto() {
        ctx = null;
        System.out.println("Contesto chiuso correttamente");
    }

}
