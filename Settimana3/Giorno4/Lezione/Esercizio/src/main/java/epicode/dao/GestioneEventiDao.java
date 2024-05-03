package epicode.dao;


import epicode.entity.gestioneEventi.GestioneEventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GestioneEventiDao {
    private EntityManager em;

    //INSERIMENTO DEL COSTRUTTORE
    public GestioneEventiDao(EntityManager em) {
        this.em = em;
    }

    //INSERIMETNO DI UN EVENTO
    public void save(GestioneEventi gestioneEventi) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(gestioneEventi);
        et.commit();
    }

    //ELIMINAZIONE DI UN EVENTO
    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        GestioneEventi gestioneEventi = getById(id);
        if (gestioneEventi != null) {
            em.remove(gestioneEventi);
        } else {
            System.out.println("Nessun evento trovato con l'ID fornito.");
        }
        et.commit();
    }

    //RICERCA DI UN EVENTO IN BASE AL SUO ID
    public GestioneEventi getById(int id) {
        return em.find(GestioneEventi.class, id);
    }
}
