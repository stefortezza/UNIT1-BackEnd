package epicode;

import epicode.dao.GestioneEventiDao;
import epicode.entity.GestioneEventi;
import epicode.entity.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        GestioneEventiDao dao = new GestioneEventiDao(em);

        //AGGIUNTA DI UN EVENTO
        GestioneEventi e1 = new GestioneEventi();
        e1.setTitolo("Festa del 1 Maggio");
        e1.setDataEvento(LocalDate.of(2024, 05, 01));
        e1.setDescrizione("Festa dei lavoratori");
        e1.setTipoEvento(TipoEvento.PUBBLICO);
        e1.setNumeroMassimoPartecipanti(500);

        dao.save(e1);

        //AGGIUNTA DI UN SECONDO EVENTO
        GestioneEventi e2 = new GestioneEventi();
        e2.setTitolo("Festa di Compleanno");
        e2.setDataEvento(LocalDate.of(2024, 07, 28));
        e2.setDescrizione("Festeggerò la mia festa di compleanno");
        e2.setTipoEvento(TipoEvento.PRIVATO);
        e2.setNumeroMassimoPartecipanti(150);

        //dao.save(e2);

        //MODIFICA DEL SECONDO EVENTO, DA PRIVATO A PUBBLICO
        e2.setTipoEvento(TipoEvento.PUBBLICO);
        //dao.save(e2);

        //ELIMIAZIONE DI UN EVENTO TRAMITE ID
        //dao.delete(1);
        //dao.delete(e1);

        //STAMPA DELL'EVENTO TRAMITE ID
        //GestioneEventi gbi1 = dao.getById(1);
        //System.out.println(gbi1);

        //AGGIUNTA DI UN TERZO EVENTO
        GestioneEventi e3 = new GestioneEventi();
        e3.setTitolo("Festa di Natale");
        e3.setDataEvento(LocalDate.of(2024, 12, 25));
        e3.setDescrizione("Festeggiamenti di Natale in famiglia");
        e3.setTipoEvento(TipoEvento.PRIVATO);
        e3.setNumeroMassimoPartecipanti(100);

        //dao.save(e3);
    }
}
