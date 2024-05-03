package epicode.dao;

import epicode.entity.persona.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
