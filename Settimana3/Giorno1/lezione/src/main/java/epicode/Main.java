package epicode;

import epicode.dao.StudenteDao;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_jpa");
        EntityManager em = emf.createEntityManager();

        StudenteDao dao = new StudenteDao(em);

        Studente s1 = new Studente();
        s1.setNome("Stefano");
        s1.setCognome("Fortezza");
        s1.setIndirizzo("Via Roma");
        s1.setDataNascita(LocalDate.of(1998, 7, 28));

        //salvataggio di uno studente senza matricola (generata automaticamente da JPA)
        //dao.save(s1);

        //ESTRAZIONE DAL DB DI UNO STUDENTE CON UNA DETERMINATA MATRICOLA

        //Studente s2 = dao.getById(1);
        //System.out.println(s2);

        //AGGIORNAMENTO DI UN DATO, IN QUESTO CASO E' L'INDIRIZZO

        //s2.setIndirizzo("Via dei Greci");
        //dao.save(s2);

        //ELIMINAZIONE DI UNO STUDENTE

        dao.delete(s1);
    }
}
