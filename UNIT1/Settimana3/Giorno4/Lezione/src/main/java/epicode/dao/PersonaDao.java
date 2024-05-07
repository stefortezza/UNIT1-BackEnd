package epicode.dao;

import epicode.entity.persona.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PersonaDao {
    private EntityManager em;

    //INSERIMENTO DEL COSTRUTTORE
    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    //INSERIMETNO DI UN EVENTO
    public void save(Persona persona) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(persona);
        et.commit();
    }

    //ELIMINAZIONE DI UN EVENTO
    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Persona persona = getById(id);
        if (persona != null) {
            em.remove(persona);
        } else {
            System.out.println("Persona non trovata");
        }
        et.commit();
    }

    //RICERCA DI UN EVENTO IN BASE AL SUO ID
    public Persona getById(int id) {
        return em.find(Persona.class, id);
    }

    //UTILIZZO DELLA QUERY
    public List<Persona> getPersonaByName(String nome) {
        Query query = em.createNamedQuery("getPersonaByName");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public List<Persona> getPersonaByCognome(String cognome) {
        Query query = em.createQuery("select p from Persona p where p.Cognome= :cognome");
        query.setParameter("cognome", cognome);
        return query.getResultList();
    }

    public List<Persona> getPersonaByPartName(String nome) {
        Query query = em.createQuery("select p from Persona p where p.Nome like :nome ");
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
}
