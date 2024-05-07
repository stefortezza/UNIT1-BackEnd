package epicode.dao;

import epicode.entity.gestioneEventi.GestioneEventi;
import epicode.entity.partecipazione.Partecipazione;
import epicode.entity.persona.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PartecipazioneDao {
    private EntityManager em;

    //INSERIMENTO DEL COSTRUTTORE
    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    //INSERIMETNO DI UN EVENTO
    public void save(Partecipazione partecipazione) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(partecipazione);
        et.commit();
    }

    //ELIMINAZIONE DI UN EVENTO
    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Partecipazione partecipazione = getById(id);
        if (partecipazione != null) {
            em.remove(partecipazione);
        } else {
            System.out.println("Nessuna partecipazione trovata");
        }
        et.commit();
    }

    //RICERCA DI UN EVENTO IN BASE AL SUO ID
    public Partecipazione getById(int id) {
        return em.find(Partecipazione.class, id);
    }

    public List<Persona> getPersonaByEvento (GestioneEventi gestioneEventi) {
        Query query = em.createNamedQuery("getPersonaByEvento");
        query.setParameter("evento", gestioneEventi);
        return query.getResultList();
    }

    public Long countPersonaByEvento (GestioneEventi gestioneEventi) {
        Query query = em.createQuery("select count(part) from Partecipazione part where part.evento= :evento");
        query.setParameter("evento", gestioneEventi);
        return (Long) query.getSingleResult();
    }
}
